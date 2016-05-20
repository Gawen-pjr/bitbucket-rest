
# bitbucket-rest

java-based client to interact with Bitbucket's REST API. 

## Setup

Client's can be built like so:

      BitbucketClient client = new BitbucketClient.Builder()
      .endPoint("http://127.0.0.1:7990") // Optional. Defaults to http://127.0.0.1:7990
      .credentials("admin:password") // Optional.
      .build();

      Version version = client.api().systemApi().version();
      
## Latest release

Can be found in jcenter:

	<dependency>
	  <groupId>com.cdancy</groupId>
	  <artifactId>bitbucket-rest</artifactId>
	  <version>0.0.1</version>
	</dependency>
	
## Documentation

javadocs can be found via [github pages here](http://cdancy.github.io/bitbucket-rest/docs/javadoc/)

## Property based setup

Client's do NOT need supply the endPoint or credentials as part of instantiating the BitbucketClient object. 
Instead one can supply them through system properties, environment variables, or a combination 
of the 2. System properties will be searched first and if not found we will attempt to 
query the environment.

Setting the `endpoint` can be done with any of the following (searched in order):

- `bitbucket.rest.endpoint`
- `bitbucketRestEndpoint`
- `BITBUCKET_REST_ENDPOINT`

Setting the `credentials` can be done with any of the following (searched in order):

- `bitbucket.rest.credentials`
- `bitbucketRestCredentials`
- `BITBUCKET_REST_CREDENTIALS`

## Credentials

bitbucket-rest credentials can take 1 of 2 forms:

- Colon delimited username and password: __admin:password__ 
- Base64 encoded username and password: __YWRtaW46cGFzc3dvcmQ=__ 

## Examples

The [mock](https://github.com/cdancy/bitbucket-rest/tree/master/src/test/java/com/cdancy/bitbucket/rest/features) and [live](https://github.com/cdancy/bitbucket-rest/tree/master/src/test/java/com/cdancy/bitbucket/rest/features) tests provide many examples
that you can use in your own code.

## Components

- jclouds \- used as the backend for communicating with Bitbucket's REST API
- AutoValue \- used to create immutable value types both to and from the bitbucket program
    
## Testing

Running mock tests can be done like so:

	./gradlew clean build mockTest
	
Running integration tests can be done like so (requires docker):

	./gradlew clean build integTest
	
Running integration tests without invoking docker can be done like so:

	./gradlew clean build integTest -PbootstrapDocker=false -PtestBitbucketEndpoint=http://127.0.0.1:7990 
	
# Additional Resources

* [Bitbucket REST API](https://developer.atlassian.com/static/rest/bitbucket-server/latest/bitbucket-rest.html)
* [Bitbucket Auth API](https://developer.atlassian.com/bitbucket/server/docs/latest/how-tos/example-basic-authentication.html)
* [Apache jclouds](https://jclouds.apache.org/start/)
