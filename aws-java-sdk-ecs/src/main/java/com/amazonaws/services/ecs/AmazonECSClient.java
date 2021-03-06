/*
 * Copyright 2010-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 * 
 *  http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.ecs;

import java.net.*;
import java.util.*;

import org.apache.commons.logging.*;

import com.amazonaws.*;
import com.amazonaws.regions.*;
import com.amazonaws.auth.*;
import com.amazonaws.handlers.*;
import com.amazonaws.http.*;
import com.amazonaws.regions.*;
import com.amazonaws.internal.*;
import com.amazonaws.metrics.*;
import com.amazonaws.transform.*;
import com.amazonaws.util.*;
import com.amazonaws.util.AWSRequestMetrics.Field;
import com.amazonaws.util.json.*;

import com.amazonaws.services.ecs.model.*;
import com.amazonaws.services.ecs.model.transform.*;

/**
 * Client for accessing AmazonECS.  All service calls made
 * using this client are blocking, and will not return until the service call
 * completes.
 * <p>
 * <p>
 * Amazon EC2 Container Service (Amazon ECS) is a highly scalable, fast,
 * container management service that makes it easy to run, stop, and
 * manage Docker containers on a cluster of Amazon EC2 instances. Amazon
 * ECS lets you launch and stop container-enabled applications with
 * simple API calls, allows you to get the state of your cluster from a
 * centralized service, and gives you access to many familiar Amazon EC2
 * features like security groups, Amazon EBS volumes, and IAM roles.
 * </p>
 * <p>
 * You can use Amazon ECS to schedule the placement of containers across
 * your cluster based on your resource needs, isolation policies, and
 * availability requirements. Amazon EC2 Container Service eliminates the
 * need for you to operate your own cluster management and configuration
 * management systems or worry about scaling your management
 * infrastructure.
 * </p>
 */
public class AmazonECSClient extends AmazonWebServiceClient implements AmazonECS {

    /** Provider for AWS credentials. */
    private AWSCredentialsProvider awsCredentialsProvider;

    private static final Log log = LogFactory.getLog(AmazonECS.class);

    /**
     * List of exception unmarshallers for all AmazonECS exceptions.
     */
    protected List<JsonErrorUnmarshaller> jsonErrorUnmarshallers;

    /**
     * Constructs a new client to invoke service methods on
     * AmazonECS.  A credentials provider chain will be used
     * that searches for credentials in this order:
     * <ul>
     *  <li> Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY </li>
     *  <li> Java System Properties - aws.accessKeyId and aws.secretKey </li>
     *  <li> Instance profile credentials delivered through the Amazon EC2 metadata service </li>
     * </ul>
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @see DefaultAWSCredentialsProviderChain
     */
    public AmazonECSClient() {
        this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonECS.  A credentials provider chain will be used
     * that searches for credentials in this order:
     * <ul>
     *  <li> Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY </li>
     *  <li> Java System Properties - aws.accessKeyId and aws.secretKey </li>
     *  <li> Instance profile credentials delivered through the Amazon EC2 metadata service </li>
     * </ul>
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonECS
     *                       (ex: proxy settings, retry counts, etc.).
     *
     * @see DefaultAWSCredentialsProviderChain
     */
    public AmazonECSClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonECS using the specified AWS account credentials.
     * 
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentials The AWS credentials (access key ID and secret key) to use
     *                       when authenticating with AWS services.
     */
    public AmazonECSClient(AWSCredentials awsCredentials) {
        this(awsCredentials, new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonECS using the specified AWS account credentials
     * and client configuration options.
     * 
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentials The AWS credentials (access key ID and secret key) to use
     *                       when authenticating with AWS services.
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonECS
     *                       (ex: proxy settings, retry counts, etc.).
     */
    public AmazonECSClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration) {
        super(adjustClientConfiguration(clientConfiguration));
        
        this.awsCredentialsProvider = new StaticCredentialsProvider(awsCredentials);
        
        init();
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonECS using the specified AWS account credentials provider.
     * 
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     */
    public AmazonECSClient(AWSCredentialsProvider awsCredentialsProvider) {
        this(awsCredentialsProvider, new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonECS using the specified AWS account credentials
     * provider and client configuration options.
     * 
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonECS
     *                       (ex: proxy settings, retry counts, etc.).
     */
    public AmazonECSClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration) {
        this(awsCredentialsProvider, clientConfiguration, null);
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonECS using the specified AWS account credentials
     * provider, client configuration options and request metric collector.
     * 
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonECS
     *                       (ex: proxy settings, retry counts, etc.).
     * @param requestMetricCollector optional request metric collector
     */
    public AmazonECSClient(AWSCredentialsProvider awsCredentialsProvider,
            ClientConfiguration clientConfiguration,
            RequestMetricCollector requestMetricCollector) {
        super(adjustClientConfiguration(clientConfiguration), requestMetricCollector);
        
        this.awsCredentialsProvider = awsCredentialsProvider;
        
        init();
    }

    private void init() {
        jsonErrorUnmarshallers = new ArrayList<JsonErrorUnmarshaller>();
        jsonErrorUnmarshallers.add(new ClientExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new ServerExceptionUnmarshaller());
        
        jsonErrorUnmarshallers.add(new JsonErrorUnmarshaller());
        
        // calling this.setEndPoint(...) will also modify the signer accordingly
        this.setEndpoint("ecs.us-east-1.amazonaws.com");
        
        HandlerChainFactory chainFactory = new HandlerChainFactory();
        requestHandler2s.addAll(chainFactory.newRequestHandlerChain(
                "/com/amazonaws/services/ecs/request.handlers"));
        requestHandler2s.addAll(chainFactory.newRequestHandler2Chain(
                "/com/amazonaws/services/ecs/request.handler2s"));
    }

    private static ClientConfiguration adjustClientConfiguration(ClientConfiguration orig) {
        ClientConfiguration config = orig;
        
        return config;
    }

    /**
     * <p>
     * <b>NOTE:</b> This action is only used by the Amazon EC2 Container
     * Service agent, and it is not intended for use outside of the agent.
     * </p>
     * <p>
     * Sent to acknowledge that a task changed states.
     * </p>
     *
     * @param submitTaskStateChangeRequest Container for the necessary
     *           parameters to execute the SubmitTaskStateChange service method on
     *           AmazonECS.
     * 
     * @return The response from the SubmitTaskStateChange service method, as
     *         returned by AmazonECS.
     * 
     * @throws ServerException
     * @throws ClientException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonECS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public SubmitTaskStateChangeResult submitTaskStateChange(SubmitTaskStateChangeRequest submitTaskStateChangeRequest) {
        ExecutionContext executionContext = createExecutionContext(submitTaskStateChangeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<SubmitTaskStateChangeRequest> request = null;
        Response<SubmitTaskStateChangeResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new SubmitTaskStateChangeRequestMarshaller().marshall(submitTaskStateChangeRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<SubmitTaskStateChangeResult, JsonUnmarshallerContext> unmarshaller =
                new SubmitTaskStateChangeResultJsonUnmarshaller();
            JsonResponseHandler<SubmitTaskStateChangeResult> responseHandler =
                new JsonResponseHandler<SubmitTaskStateChangeResult>(unmarshaller);
            
            response = invoke(request, responseHandler, executionContext);
            
            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Deletes the specified cluster. You must deregister all container
     * instances from this cluster before you may delete it. You can list the
     * container instances in a cluster with ListContainerInstances and
     * deregister them with DeregisterContainerInstance.
     * </p>
     *
     * @param deleteClusterRequest Container for the necessary parameters to
     *           execute the DeleteCluster service method on AmazonECS.
     * 
     * @return The response from the DeleteCluster service method, as
     *         returned by AmazonECS.
     * 
     * @throws ServerException
     * @throws ClientException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonECS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DeleteClusterResult deleteCluster(DeleteClusterRequest deleteClusterRequest) {
        ExecutionContext executionContext = createExecutionContext(deleteClusterRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteClusterRequest> request = null;
        Response<DeleteClusterResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteClusterRequestMarshaller().marshall(deleteClusterRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DeleteClusterResult, JsonUnmarshallerContext> unmarshaller =
                new DeleteClusterResultJsonUnmarshaller();
            JsonResponseHandler<DeleteClusterResult> responseHandler =
                new JsonResponseHandler<DeleteClusterResult>(unmarshaller);
            
            response = invoke(request, responseHandler, executionContext);
            
            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * <b>NOTE:</b> This action is only used by the Amazon EC2 Container
     * Service agent, and it is not intended for use outside of the agent.
     * </p>
     * <p>
     * Registers an Amazon EC2 instance into the specified cluster. This
     * instance will become available to place containers on.
     * </p>
     *
     * @param registerContainerInstanceRequest Container for the necessary
     *           parameters to execute the RegisterContainerInstance service method on
     *           AmazonECS.
     * 
     * @return The response from the RegisterContainerInstance service
     *         method, as returned by AmazonECS.
     * 
     * @throws ServerException
     * @throws ClientException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonECS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public RegisterContainerInstanceResult registerContainerInstance(RegisterContainerInstanceRequest registerContainerInstanceRequest) {
        ExecutionContext executionContext = createExecutionContext(registerContainerInstanceRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<RegisterContainerInstanceRequest> request = null;
        Response<RegisterContainerInstanceResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new RegisterContainerInstanceRequestMarshaller().marshall(registerContainerInstanceRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<RegisterContainerInstanceResult, JsonUnmarshallerContext> unmarshaller =
                new RegisterContainerInstanceResultJsonUnmarshaller();
            JsonResponseHandler<RegisterContainerInstanceResult> responseHandler =
                new JsonResponseHandler<RegisterContainerInstanceResult>(unmarshaller);
            
            response = invoke(request, responseHandler, executionContext);
            
            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Describes Amazon EC2 Container Service container instances. Returns
     * metadata about registered and remaining resources on each container
     * instance requested.
     * </p>
     *
     * @param describeContainerInstancesRequest Container for the necessary
     *           parameters to execute the DescribeContainerInstances service method on
     *           AmazonECS.
     * 
     * @return The response from the DescribeContainerInstances service
     *         method, as returned by AmazonECS.
     * 
     * @throws ServerException
     * @throws ClientException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonECS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeContainerInstancesResult describeContainerInstances(DescribeContainerInstancesRequest describeContainerInstancesRequest) {
        ExecutionContext executionContext = createExecutionContext(describeContainerInstancesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeContainerInstancesRequest> request = null;
        Response<DescribeContainerInstancesResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeContainerInstancesRequestMarshaller().marshall(describeContainerInstancesRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DescribeContainerInstancesResult, JsonUnmarshallerContext> unmarshaller =
                new DescribeContainerInstancesResultJsonUnmarshaller();
            JsonResponseHandler<DescribeContainerInstancesResult> responseHandler =
                new JsonResponseHandler<DescribeContainerInstancesResult>(unmarshaller);
            
            response = invoke(request, responseHandler, executionContext);
            
            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * <b>NOTE:</b> This action is only used by the Amazon EC2 Container
     * Service agent, and it is not intended for use outside of the agent.
     * </p>
     * <p>
     * Sent to acknowledge that a container changed states.
     * </p>
     *
     * @param submitContainerStateChangeRequest Container for the necessary
     *           parameters to execute the SubmitContainerStateChange service method on
     *           AmazonECS.
     * 
     * @return The response from the SubmitContainerStateChange service
     *         method, as returned by AmazonECS.
     * 
     * @throws ServerException
     * @throws ClientException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonECS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public SubmitContainerStateChangeResult submitContainerStateChange(SubmitContainerStateChangeRequest submitContainerStateChangeRequest) {
        ExecutionContext executionContext = createExecutionContext(submitContainerStateChangeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<SubmitContainerStateChangeRequest> request = null;
        Response<SubmitContainerStateChangeResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new SubmitContainerStateChangeRequestMarshaller().marshall(submitContainerStateChangeRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<SubmitContainerStateChangeResult, JsonUnmarshallerContext> unmarshaller =
                new SubmitContainerStateChangeResultJsonUnmarshaller();
            JsonResponseHandler<SubmitContainerStateChangeResult> responseHandler =
                new JsonResponseHandler<SubmitContainerStateChangeResult>(unmarshaller);
            
            response = invoke(request, responseHandler, executionContext);
            
            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Returns a list of task definitions that are registered to your
     * account. You can filter the results by family name with the
     * <code>familyPrefix</code> parameter.
     * </p>
     *
     * @param listTaskDefinitionsRequest Container for the necessary
     *           parameters to execute the ListTaskDefinitions service method on
     *           AmazonECS.
     * 
     * @return The response from the ListTaskDefinitions service method, as
     *         returned by AmazonECS.
     * 
     * @throws ServerException
     * @throws ClientException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonECS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListTaskDefinitionsResult listTaskDefinitions(ListTaskDefinitionsRequest listTaskDefinitionsRequest) {
        ExecutionContext executionContext = createExecutionContext(listTaskDefinitionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListTaskDefinitionsRequest> request = null;
        Response<ListTaskDefinitionsResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListTaskDefinitionsRequestMarshaller().marshall(listTaskDefinitionsRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListTaskDefinitionsResult, JsonUnmarshallerContext> unmarshaller =
                new ListTaskDefinitionsResultJsonUnmarshaller();
            JsonResponseHandler<ListTaskDefinitionsResult> responseHandler =
                new JsonResponseHandler<ListTaskDefinitionsResult>(unmarshaller);
            
            response = invoke(request, responseHandler, executionContext);
            
            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Describes a specified task or tasks.
     * </p>
     *
     * @param describeTasksRequest Container for the necessary parameters to
     *           execute the DescribeTasks service method on AmazonECS.
     * 
     * @return The response from the DescribeTasks service method, as
     *         returned by AmazonECS.
     * 
     * @throws ServerException
     * @throws ClientException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonECS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeTasksResult describeTasks(DescribeTasksRequest describeTasksRequest) {
        ExecutionContext executionContext = createExecutionContext(describeTasksRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeTasksRequest> request = null;
        Response<DescribeTasksResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeTasksRequestMarshaller().marshall(describeTasksRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DescribeTasksResult, JsonUnmarshallerContext> unmarshaller =
                new DescribeTasksResultJsonUnmarshaller();
            JsonResponseHandler<DescribeTasksResult> responseHandler =
                new JsonResponseHandler<DescribeTasksResult>(unmarshaller);
            
            response = invoke(request, responseHandler, executionContext);
            
            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Start a task using random placement and the default Amazon ECS
     * scheduler. If you want to use your own scheduler or place a task on a
     * specific container instance, use <code>StartTask</code> instead.
     * </p>
     *
     * @param runTaskRequest Container for the necessary parameters to
     *           execute the RunTask service method on AmazonECS.
     * 
     * @return The response from the RunTask service method, as returned by
     *         AmazonECS.
     * 
     * @throws ServerException
     * @throws ClientException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonECS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public RunTaskResult runTask(RunTaskRequest runTaskRequest) {
        ExecutionContext executionContext = createExecutionContext(runTaskRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<RunTaskRequest> request = null;
        Response<RunTaskResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new RunTaskRequestMarshaller().marshall(runTaskRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<RunTaskResult, JsonUnmarshallerContext> unmarshaller =
                new RunTaskResultJsonUnmarshaller();
            JsonResponseHandler<RunTaskResult> responseHandler =
                new JsonResponseHandler<RunTaskResult>(unmarshaller);
            
            response = invoke(request, responseHandler, executionContext);
            
            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Returns a list of existing clusters.
     * </p>
     *
     * @param listClustersRequest Container for the necessary parameters to
     *           execute the ListClusters service method on AmazonECS.
     * 
     * @return The response from the ListClusters service method, as returned
     *         by AmazonECS.
     * 
     * @throws ServerException
     * @throws ClientException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonECS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListClustersResult listClusters(ListClustersRequest listClustersRequest) {
        ExecutionContext executionContext = createExecutionContext(listClustersRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListClustersRequest> request = null;
        Response<ListClustersResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListClustersRequestMarshaller().marshall(listClustersRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListClustersResult, JsonUnmarshallerContext> unmarshaller =
                new ListClustersResultJsonUnmarshaller();
            JsonResponseHandler<ListClustersResult> responseHandler =
                new JsonResponseHandler<ListClustersResult>(unmarshaller);
            
            response = invoke(request, responseHandler, executionContext);
            
            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * <b>NOTE:</b> This action is only used by the Amazon EC2 Container
     * Service agent, and it is not intended for use outside of the agent.
     * </p>
     * <p>
     * Returns an endpoint for the Amazon EC2 Container Service agent to
     * poll for updates.
     * </p>
     *
     * @param discoverPollEndpointRequest Container for the necessary
     *           parameters to execute the DiscoverPollEndpoint service method on
     *           AmazonECS.
     * 
     * @return The response from the DiscoverPollEndpoint service method, as
     *         returned by AmazonECS.
     * 
     * @throws ServerException
     * @throws ClientException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonECS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DiscoverPollEndpointResult discoverPollEndpoint(DiscoverPollEndpointRequest discoverPollEndpointRequest) {
        ExecutionContext executionContext = createExecutionContext(discoverPollEndpointRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DiscoverPollEndpointRequest> request = null;
        Response<DiscoverPollEndpointResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DiscoverPollEndpointRequestMarshaller().marshall(discoverPollEndpointRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DiscoverPollEndpointResult, JsonUnmarshallerContext> unmarshaller =
                new DiscoverPollEndpointResultJsonUnmarshaller();
            JsonResponseHandler<DiscoverPollEndpointResult> responseHandler =
                new JsonResponseHandler<DiscoverPollEndpointResult>(unmarshaller);
            
            response = invoke(request, responseHandler, executionContext);
            
            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Creates a new Amazon ECS cluster. By default, your account will
     * receive a <code>default</code> cluster when you launch your first
     * container instance. However, you can create your own cluster with a
     * unique name with the <code>CreateCluster</code> action.
     * </p>
     * <p>
     * <b>IMPORTANT:</b> During the preview, each account is limited to two
     * clusters.
     * </p>
     *
     * @param createClusterRequest Container for the necessary parameters to
     *           execute the CreateCluster service method on AmazonECS.
     * 
     * @return The response from the CreateCluster service method, as
     *         returned by AmazonECS.
     * 
     * @throws ServerException
     * @throws ClientException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonECS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public CreateClusterResult createCluster(CreateClusterRequest createClusterRequest) {
        ExecutionContext executionContext = createExecutionContext(createClusterRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateClusterRequest> request = null;
        Response<CreateClusterResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateClusterRequestMarshaller().marshall(createClusterRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<CreateClusterResult, JsonUnmarshallerContext> unmarshaller =
                new CreateClusterResultJsonUnmarshaller();
            JsonResponseHandler<CreateClusterResult> responseHandler =
                new JsonResponseHandler<CreateClusterResult>(unmarshaller);
            
            response = invoke(request, responseHandler, executionContext);
            
            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Describes one or more of your clusters.
     * </p>
     *
     * @param describeClustersRequest Container for the necessary parameters
     *           to execute the DescribeClusters service method on AmazonECS.
     * 
     * @return The response from the DescribeClusters service method, as
     *         returned by AmazonECS.
     * 
     * @throws ServerException
     * @throws ClientException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonECS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeClustersResult describeClusters(DescribeClustersRequest describeClustersRequest) {
        ExecutionContext executionContext = createExecutionContext(describeClustersRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeClustersRequest> request = null;
        Response<DescribeClustersResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeClustersRequestMarshaller().marshall(describeClustersRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DescribeClustersResult, JsonUnmarshallerContext> unmarshaller =
                new DescribeClustersResultJsonUnmarshaller();
            JsonResponseHandler<DescribeClustersResult> responseHandler =
                new JsonResponseHandler<DescribeClustersResult>(unmarshaller);
            
            response = invoke(request, responseHandler, executionContext);
            
            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * NOT YET IMPLEMENTED.
     * </p>
     * <p>
     * Deregisters the specified task definition. You will no longer be able
     * to run tasks from this definition after deregistration.
     * </p>
     *
     * @param deregisterTaskDefinitionRequest Container for the necessary
     *           parameters to execute the DeregisterTaskDefinition service method on
     *           AmazonECS.
     * 
     * @return The response from the DeregisterTaskDefinition service method,
     *         as returned by AmazonECS.
     * 
     * @throws ServerException
     * @throws ClientException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonECS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DeregisterTaskDefinitionResult deregisterTaskDefinition(DeregisterTaskDefinitionRequest deregisterTaskDefinitionRequest) {
        ExecutionContext executionContext = createExecutionContext(deregisterTaskDefinitionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeregisterTaskDefinitionRequest> request = null;
        Response<DeregisterTaskDefinitionResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeregisterTaskDefinitionRequestMarshaller().marshall(deregisterTaskDefinitionRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DeregisterTaskDefinitionResult, JsonUnmarshallerContext> unmarshaller =
                new DeregisterTaskDefinitionResultJsonUnmarshaller();
            JsonResponseHandler<DeregisterTaskDefinitionResult> responseHandler =
                new JsonResponseHandler<DeregisterTaskDefinitionResult>(unmarshaller);
            
            response = invoke(request, responseHandler, executionContext);
            
            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Returns a list of container instances in a specified cluster.
     * </p>
     *
     * @param listContainerInstancesRequest Container for the necessary
     *           parameters to execute the ListContainerInstances service method on
     *           AmazonECS.
     * 
     * @return The response from the ListContainerInstances service method,
     *         as returned by AmazonECS.
     * 
     * @throws ServerException
     * @throws ClientException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonECS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListContainerInstancesResult listContainerInstances(ListContainerInstancesRequest listContainerInstancesRequest) {
        ExecutionContext executionContext = createExecutionContext(listContainerInstancesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListContainerInstancesRequest> request = null;
        Response<ListContainerInstancesResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListContainerInstancesRequestMarshaller().marshall(listContainerInstancesRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListContainerInstancesResult, JsonUnmarshallerContext> unmarshaller =
                new ListContainerInstancesResultJsonUnmarshaller();
            JsonResponseHandler<ListContainerInstancesResult> responseHandler =
                new JsonResponseHandler<ListContainerInstancesResult>(unmarshaller);
            
            response = invoke(request, responseHandler, executionContext);
            
            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Deregisters an Amazon ECS container instance from the specified
     * cluster. This instance will no longer be available to run tasks.
     * </p>
     *
     * @param deregisterContainerInstanceRequest Container for the necessary
     *           parameters to execute the DeregisterContainerInstance service method
     *           on AmazonECS.
     * 
     * @return The response from the DeregisterContainerInstance service
     *         method, as returned by AmazonECS.
     * 
     * @throws ServerException
     * @throws ClientException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonECS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DeregisterContainerInstanceResult deregisterContainerInstance(DeregisterContainerInstanceRequest deregisterContainerInstanceRequest) {
        ExecutionContext executionContext = createExecutionContext(deregisterContainerInstanceRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeregisterContainerInstanceRequest> request = null;
        Response<DeregisterContainerInstanceResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeregisterContainerInstanceRequestMarshaller().marshall(deregisterContainerInstanceRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DeregisterContainerInstanceResult, JsonUnmarshallerContext> unmarshaller =
                new DeregisterContainerInstanceResultJsonUnmarshaller();
            JsonResponseHandler<DeregisterContainerInstanceResult> responseHandler =
                new JsonResponseHandler<DeregisterContainerInstanceResult>(unmarshaller);
            
            response = invoke(request, responseHandler, executionContext);
            
            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Starts a new task from the specified task definition on the specified
     * container instance or instances. If you want to use the default Amazon
     * ECS scheduler to place your task, use <code>RunTask</code> instead.
     * </p>
     *
     * @param startTaskRequest Container for the necessary parameters to
     *           execute the StartTask service method on AmazonECS.
     * 
     * @return The response from the StartTask service method, as returned by
     *         AmazonECS.
     * 
     * @throws ServerException
     * @throws ClientException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonECS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public StartTaskResult startTask(StartTaskRequest startTaskRequest) {
        ExecutionContext executionContext = createExecutionContext(startTaskRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<StartTaskRequest> request = null;
        Response<StartTaskResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new StartTaskRequestMarshaller().marshall(startTaskRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<StartTaskResult, JsonUnmarshallerContext> unmarshaller =
                new StartTaskResultJsonUnmarshaller();
            JsonResponseHandler<StartTaskResult> responseHandler =
                new JsonResponseHandler<StartTaskResult>(unmarshaller);
            
            response = invoke(request, responseHandler, executionContext);
            
            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Describes a task definition.
     * </p>
     *
     * @param describeTaskDefinitionRequest Container for the necessary
     *           parameters to execute the DescribeTaskDefinition service method on
     *           AmazonECS.
     * 
     * @return The response from the DescribeTaskDefinition service method,
     *         as returned by AmazonECS.
     * 
     * @throws ServerException
     * @throws ClientException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonECS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeTaskDefinitionResult describeTaskDefinition(DescribeTaskDefinitionRequest describeTaskDefinitionRequest) {
        ExecutionContext executionContext = createExecutionContext(describeTaskDefinitionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeTaskDefinitionRequest> request = null;
        Response<DescribeTaskDefinitionResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeTaskDefinitionRequestMarshaller().marshall(describeTaskDefinitionRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DescribeTaskDefinitionResult, JsonUnmarshallerContext> unmarshaller =
                new DescribeTaskDefinitionResultJsonUnmarshaller();
            JsonResponseHandler<DescribeTaskDefinitionResult> responseHandler =
                new JsonResponseHandler<DescribeTaskDefinitionResult>(unmarshaller);
            
            response = invoke(request, responseHandler, executionContext);
            
            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Returns a list of tasks for a specified cluster. You can filter the
     * results by family name or by a particular container instance with the
     * <code>family</code> and <code>containerInstance</code> parameters.
     * </p>
     *
     * @param listTasksRequest Container for the necessary parameters to
     *           execute the ListTasks service method on AmazonECS.
     * 
     * @return The response from the ListTasks service method, as returned by
     *         AmazonECS.
     * 
     * @throws ServerException
     * @throws ClientException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonECS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListTasksResult listTasks(ListTasksRequest listTasksRequest) {
        ExecutionContext executionContext = createExecutionContext(listTasksRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListTasksRequest> request = null;
        Response<ListTasksResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListTasksRequestMarshaller().marshall(listTasksRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListTasksResult, JsonUnmarshallerContext> unmarshaller =
                new ListTasksResultJsonUnmarshaller();
            JsonResponseHandler<ListTasksResult> responseHandler =
                new JsonResponseHandler<ListTasksResult>(unmarshaller);
            
            response = invoke(request, responseHandler, executionContext);
            
            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Registers a new task definition from the supplied <code>family</code>
     * and <code>containerDefinitions</code> .
     * </p>
     *
     * @param registerTaskDefinitionRequest Container for the necessary
     *           parameters to execute the RegisterTaskDefinition service method on
     *           AmazonECS.
     * 
     * @return The response from the RegisterTaskDefinition service method,
     *         as returned by AmazonECS.
     * 
     * @throws ServerException
     * @throws ClientException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonECS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public RegisterTaskDefinitionResult registerTaskDefinition(RegisterTaskDefinitionRequest registerTaskDefinitionRequest) {
        ExecutionContext executionContext = createExecutionContext(registerTaskDefinitionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<RegisterTaskDefinitionRequest> request = null;
        Response<RegisterTaskDefinitionResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new RegisterTaskDefinitionRequestMarshaller().marshall(registerTaskDefinitionRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<RegisterTaskDefinitionResult, JsonUnmarshallerContext> unmarshaller =
                new RegisterTaskDefinitionResultJsonUnmarshaller();
            JsonResponseHandler<RegisterTaskDefinitionResult> responseHandler =
                new JsonResponseHandler<RegisterTaskDefinitionResult>(unmarshaller);
            
            response = invoke(request, responseHandler, executionContext);
            
            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Stops a running task.
     * </p>
     *
     * @param stopTaskRequest Container for the necessary parameters to
     *           execute the StopTask service method on AmazonECS.
     * 
     * @return The response from the StopTask service method, as returned by
     *         AmazonECS.
     * 
     * @throws ServerException
     * @throws ClientException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonECS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public StopTaskResult stopTask(StopTaskRequest stopTaskRequest) {
        ExecutionContext executionContext = createExecutionContext(stopTaskRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<StopTaskRequest> request = null;
        Response<StopTaskResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new StopTaskRequestMarshaller().marshall(stopTaskRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<StopTaskResult, JsonUnmarshallerContext> unmarshaller =
                new StopTaskResultJsonUnmarshaller();
            JsonResponseHandler<StopTaskResult> responseHandler =
                new JsonResponseHandler<StopTaskResult>(unmarshaller);
            
            response = invoke(request, responseHandler, executionContext);
            
            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * <b>NOTE:</b> This action is only used by the Amazon EC2 Container
     * Service agent, and it is not intended for use outside of the agent.
     * </p>
     * <p>
     * Sent to acknowledge that a container changed states.
     * </p>
     * 
     * @return The response from the SubmitContainerStateChange service
     *         method, as returned by AmazonECS.
     * 
     * @throws ServerException
     * @throws ClientException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonECS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public SubmitContainerStateChangeResult submitContainerStateChange() throws AmazonServiceException, AmazonClientException {
        return submitContainerStateChange(new SubmitContainerStateChangeRequest());
    }
    
    /**
     * <p>
     * Returns a list of task definitions that are registered to your
     * account. You can filter the results by family name with the
     * <code>familyPrefix</code> parameter.
     * </p>
     * 
     * @return The response from the ListTaskDefinitions service method, as
     *         returned by AmazonECS.
     * 
     * @throws ServerException
     * @throws ClientException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonECS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListTaskDefinitionsResult listTaskDefinitions() throws AmazonServiceException, AmazonClientException {
        return listTaskDefinitions(new ListTaskDefinitionsRequest());
    }
    
    /**
     * <p>
     * Returns a list of existing clusters.
     * </p>
     * 
     * @return The response from the ListClusters service method, as returned
     *         by AmazonECS.
     * 
     * @throws ServerException
     * @throws ClientException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonECS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListClustersResult listClusters() throws AmazonServiceException, AmazonClientException {
        return listClusters(new ListClustersRequest());
    }
    
    /**
     * <p>
     * <b>NOTE:</b> This action is only used by the Amazon EC2 Container
     * Service agent, and it is not intended for use outside of the agent.
     * </p>
     * <p>
     * Returns an endpoint for the Amazon EC2 Container Service agent to
     * poll for updates.
     * </p>
     * 
     * @return The response from the DiscoverPollEndpoint service method, as
     *         returned by AmazonECS.
     * 
     * @throws ServerException
     * @throws ClientException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonECS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DiscoverPollEndpointResult discoverPollEndpoint() throws AmazonServiceException, AmazonClientException {
        return discoverPollEndpoint(new DiscoverPollEndpointRequest());
    }
    
    /**
     * <p>
     * Creates a new Amazon ECS cluster. By default, your account will
     * receive a <code>default</code> cluster when you launch your first
     * container instance. However, you can create your own cluster with a
     * unique name with the <code>CreateCluster</code> action.
     * </p>
     * <p>
     * <b>IMPORTANT:</b> During the preview, each account is limited to two
     * clusters.
     * </p>
     * 
     * @return The response from the CreateCluster service method, as
     *         returned by AmazonECS.
     * 
     * @throws ServerException
     * @throws ClientException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonECS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public CreateClusterResult createCluster() throws AmazonServiceException, AmazonClientException {
        return createCluster(new CreateClusterRequest());
    }
    
    /**
     * <p>
     * Describes one or more of your clusters.
     * </p>
     * 
     * @return The response from the DescribeClusters service method, as
     *         returned by AmazonECS.
     * 
     * @throws ServerException
     * @throws ClientException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonECS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeClustersResult describeClusters() throws AmazonServiceException, AmazonClientException {
        return describeClusters(new DescribeClustersRequest());
    }
    
    /**
     * <p>
     * Returns a list of container instances in a specified cluster.
     * </p>
     * 
     * @return The response from the ListContainerInstances service method,
     *         as returned by AmazonECS.
     * 
     * @throws ServerException
     * @throws ClientException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonECS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListContainerInstancesResult listContainerInstances() throws AmazonServiceException, AmazonClientException {
        return listContainerInstances(new ListContainerInstancesRequest());
    }
    
    /**
     * <p>
     * Returns a list of tasks for a specified cluster. You can filter the
     * results by family name or by a particular container instance with the
     * <code>family</code> and <code>containerInstance</code> parameters.
     * </p>
     * 
     * @return The response from the ListTasks service method, as returned by
     *         AmazonECS.
     * 
     * @throws ServerException
     * @throws ClientException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonECS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListTasksResult listTasks() throws AmazonServiceException, AmazonClientException {
        return listTasks(new ListTasksRequest());
    }

    @Override
    public void setEndpoint(String endpoint) {
        super.setEndpoint(endpoint);
    }

    @Override
    public void setEndpoint(String endpoint, String serviceName, String regionId) throws IllegalArgumentException {
        super.setEndpoint(endpoint, serviceName, regionId);
    }

    /**
     * Returns additional metadata for a previously executed successful, request, typically used for
     * debugging issues where a service isn't acting as expected.  This data isn't considered part
     * of the result data returned by an operation, so it's available through this separate,
     * diagnostic interface.
     * <p>
     * Response metadata is only cached for a limited period of time, so if you need to access
     * this extra diagnostic information for an executed request, you should use this method
     * to retrieve it as soon as possible after executing the request.
     *
     * @param request
     *            The originally executed request
     *
     * @return The response metadata for the specified request, or null if none
     *         is available.
     */
    public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request) {
        return client.getResponseMetadataForRequest(request);
    }

    private <X, Y extends AmazonWebServiceRequest> Response<X> invoke(Request<Y> request,
            HttpResponseHandler<AmazonWebServiceResponse<X>> responseHandler,
            ExecutionContext executionContext) {
        request.setEndpoint(endpoint);
        request.setTimeOffset(timeOffset);

        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        AWSCredentials credentials;
        awsRequestMetrics.startEvent(Field.CredentialsRequestTime);
        try {
            credentials = awsCredentialsProvider.getCredentials();
        } finally {
            awsRequestMetrics.endEvent(Field.CredentialsRequestTime);
        }

        AmazonWebServiceRequest originalRequest = request.getOriginalRequest();
        if (originalRequest != null && originalRequest.getRequestCredentials() != null) {
            credentials = originalRequest.getRequestCredentials();
        }

        executionContext.setCredentials(credentials);
        JsonErrorResponseHandler errorResponseHandler = new JsonErrorResponseHandler(jsonErrorUnmarshallers);
        Response<X> result = client.execute(request, responseHandler,
                errorResponseHandler, executionContext);
        return result;
    }
}
        