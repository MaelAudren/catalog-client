package io.swagger.client.api;

import io.swagger.client.ApiClient;

import io.swagger.client.model.CatalogObjectMetadataList;
import java.io.File;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-12-19T10:37:11.145+01:00")
@Component("io.swagger.client.api.CatalogObjectControllerApi")
public class CatalogObjectControllerApi {
    private ApiClient apiClient;

    public CatalogObjectControllerApi() {
        this(new ApiClient());
    }

    @Autowired
    public CatalogObjectControllerApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Creates a new catalog object
     * 
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Bucket not found
     * <p><b>422</b> - Invalid file content supplied
     * @param bucketId bucketId
     * @param file file
     * @param sessionID sessionID
     * @param name Name of the object or empty when a ZIP archive is uploaded (All objects inside the archive are stored inside the catalog).
     * @param kind Kind of the new object
     * @param commitMessage Commit message
     * @param objectContentType The content type of CatalogRawObject
     * @return CatalogObjectMetadataList
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CatalogObjectMetadataList createUsingPOST1(Long bucketId, File file, String sessionID, String name, String kind, String commitMessage, String objectContentType) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'bucketId' is set
        if (bucketId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'bucketId' when calling createUsingPOST1");
        }
        
        // verify the required parameter 'file' is set
        if (file == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'file' when calling createUsingPOST1");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("bucketId", bucketId);
        String path = UriComponentsBuilder.fromPath("/buckets/{bucketId}/resources").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "kind", kind));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "commitMessage", commitMessage));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "objectContentType", objectContentType));
        
        if (sessionID != null)
        headerParams.add("sessionID", apiClient.parameterToString(sessionID));
        
        if (file != null)
            formParams.add("file", new FileSystemResource(file));

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "multipart/form-data"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<CatalogObjectMetadataList> returnType = new ParameterizedTypeReference<CatalogObjectMetadataList>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Delete a catalog object
     * Delete the entire catalog object as well as its revisions. Returns the deleted CatalogRawObject&#39;s metadata
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - User not authenticated
     * <p><b>403</b> - Permission denied
     * <p><b>404</b> - Bucket or object not found
     * @param bucketId bucketId
     * @param name name
     * @param sessionID sessionID
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object deleteUsingDELETE1(Long bucketId, String name, String sessionID) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'bucketId' is set
        if (bucketId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'bucketId' when calling deleteUsingDELETE1");
        }
        
        // verify the required parameter 'name' is set
        if (name == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'name' when calling deleteUsingDELETE1");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("bucketId", bucketId);
        uriVariables.put("name", name);
        String path = UriComponentsBuilder.fromPath("/buckets/{bucketId}/resources/{name}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        if (sessionID != null)
        headerParams.add("sessionID", apiClient.parameterToString(sessionID));

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets the raw content of the last revision of a catalog object
     * 
     * <p><b>200</b> - Ok
     * <p><b>401</b> - User not authenticated
     * <p><b>403</b> - Permission denied
     * <p><b>404</b> - Bucket, catalog object or catalog object revision not found
     * @param bucketId bucketId
     * @param name name
     * @param sessionID sessionID
     * @return File
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public File getRawUsingGET(Long bucketId, String name, String sessionID) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'bucketId' is set
        if (bucketId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'bucketId' when calling getRawUsingGET");
        }
        
        // verify the required parameter 'name' is set
        if (name == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'name' when calling getRawUsingGET");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("bucketId", bucketId);
        uriVariables.put("name", name);
        String path = UriComponentsBuilder.fromPath("/buckets/{bucketId}/resources/{name}/raw").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        if (sessionID != null)
        headerParams.add("sessionID", apiClient.parameterToString(sessionID));

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<File> returnType = new ParameterizedTypeReference<File>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets a catalog object&#39;s metadata by IDs
     * Returns metadata associated to the latest revision of the catalog object.
     * <p><b>200</b> - OK
     * <p><b>401</b> - User not authenticated
     * <p><b>403</b> - Permission denied
     * <p><b>404</b> - Bucket or catalog object not found
     * @param bucketId bucketId
     * @param name name
     * @param sessionID sessionID
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object getUsingGET(Long bucketId, String name, String sessionID) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'bucketId' is set
        if (bucketId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'bucketId' when calling getUsingGET");
        }
        
        // verify the required parameter 'name' is set
        if (name == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'name' when calling getUsingGET");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("bucketId", bucketId);
        uriVariables.put("name", name);
        String path = UriComponentsBuilder.fromPath("/buckets/{bucketId}/resources/{name}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        if (sessionID != null)
        headerParams.add("sessionID", apiClient.parameterToString(sessionID));

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Lists catalog objects metadata
     * Returns catalog objects metadata associated to the latest revision.
     * <p><b>200</b> - OK
     * <p><b>206</b> - Missing object
     * <p><b>401</b> - User not authenticated
     * <p><b>403</b> - Permission denied
     * <p><b>404</b> - Bucket not found
     * @param bucketId bucketId
     * @param sessionID sessionID
     * @param kind Filter according to kind.
     * @param name Give a list of name separated by comma to get them in an archive
     * @param page Results page you want to retrieve (0..N)
     * @param size Number of records per page.
     * @param sort Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object listUsingGET1(Long bucketId, String sessionID, String kind, String name, Integer page, Integer size, List<String> sort) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'bucketId' is set
        if (bucketId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'bucketId' when calling listUsingGET1");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("bucketId", bucketId);
        String path = UriComponentsBuilder.fromPath("/buckets/{bucketId}/resources").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "kind", kind));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "size", size));
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase()), "sort", sort));
        
        if (sessionID != null)
        headerParams.add("sessionID", apiClient.parameterToString(sessionID));

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Restore a catalog object revision
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - User not authenticated
     * <p><b>403</b> - Permission denied
     * <p><b>404</b> - Bucket, object or revision not found
     * @param bucketId bucketId
     * @param name name
     * @param commitTime commitTime
     * @param sessionID sessionID
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object restoreUsingPUT(Long bucketId, String name, Long commitTime, String sessionID) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'bucketId' is set
        if (bucketId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'bucketId' when calling restoreUsingPUT");
        }
        
        // verify the required parameter 'name' is set
        if (name == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'name' when calling restoreUsingPUT");
        }
        
        // verify the required parameter 'commitTime' is set
        if (commitTime == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'commitTime' when calling restoreUsingPUT");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("bucketId", bucketId);
        uriVariables.put("name", name);
        String path = UriComponentsBuilder.fromPath("/buckets/{bucketId}/resources/{name}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "commitTime", commitTime));
        
        if (sessionID != null)
        headerParams.add("sessionID", apiClient.parameterToString(sessionID));

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}