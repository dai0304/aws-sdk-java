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
package com.amazonaws.services.ecs.model;

import java.io.Serializable;

/**
 * 
 */
public class ListTasksResult implements Serializable {

    /**
     * The list of task Amazon Resource Name (ARN) entries for the
     * <code>ListTasks</code> request.
     */
    private com.amazonaws.internal.ListWithAutoConstructFlag<String> taskArns;

    /**
     * The <code>nextToken</code> value to include in a future
     * <code>ListTasks</code> request. When the results of a
     * <code>ListTasks</code> request exceed <code>maxResults</code>, this
     * value can be used to retrieve the next page of results. This value is
     * <code>null</code> when there are no more results to return.
     */
    private String nextToken;

    /**
     * The list of task Amazon Resource Name (ARN) entries for the
     * <code>ListTasks</code> request.
     *
     * @return The list of task Amazon Resource Name (ARN) entries for the
     *         <code>ListTasks</code> request.
     */
    public java.util.List<String> getTaskArns() {
        if (taskArns == null) {
              taskArns = new com.amazonaws.internal.ListWithAutoConstructFlag<String>();
              taskArns.setAutoConstruct(true);
        }
        return taskArns;
    }
    
    /**
     * The list of task Amazon Resource Name (ARN) entries for the
     * <code>ListTasks</code> request.
     *
     * @param taskArns The list of task Amazon Resource Name (ARN) entries for the
     *         <code>ListTasks</code> request.
     */
    public void setTaskArns(java.util.Collection<String> taskArns) {
        if (taskArns == null) {
            this.taskArns = null;
            return;
        }
        com.amazonaws.internal.ListWithAutoConstructFlag<String> taskArnsCopy = new com.amazonaws.internal.ListWithAutoConstructFlag<String>(taskArns.size());
        taskArnsCopy.addAll(taskArns);
        this.taskArns = taskArnsCopy;
    }
    
    /**
     * The list of task Amazon Resource Name (ARN) entries for the
     * <code>ListTasks</code> request.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param taskArns The list of task Amazon Resource Name (ARN) entries for the
     *         <code>ListTasks</code> request.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public ListTasksResult withTaskArns(String... taskArns) {
        if (getTaskArns() == null) setTaskArns(new java.util.ArrayList<String>(taskArns.length));
        for (String value : taskArns) {
            getTaskArns().add(value);
        }
        return this;
    }
    
    /**
     * The list of task Amazon Resource Name (ARN) entries for the
     * <code>ListTasks</code> request.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param taskArns The list of task Amazon Resource Name (ARN) entries for the
     *         <code>ListTasks</code> request.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public ListTasksResult withTaskArns(java.util.Collection<String> taskArns) {
        if (taskArns == null) {
            this.taskArns = null;
        } else {
            com.amazonaws.internal.ListWithAutoConstructFlag<String> taskArnsCopy = new com.amazonaws.internal.ListWithAutoConstructFlag<String>(taskArns.size());
            taskArnsCopy.addAll(taskArns);
            this.taskArns = taskArnsCopy;
        }

        return this;
    }

    /**
     * The <code>nextToken</code> value to include in a future
     * <code>ListTasks</code> request. When the results of a
     * <code>ListTasks</code> request exceed <code>maxResults</code>, this
     * value can be used to retrieve the next page of results. This value is
     * <code>null</code> when there are no more results to return.
     *
     * @return The <code>nextToken</code> value to include in a future
     *         <code>ListTasks</code> request. When the results of a
     *         <code>ListTasks</code> request exceed <code>maxResults</code>, this
     *         value can be used to retrieve the next page of results. This value is
     *         <code>null</code> when there are no more results to return.
     */
    public String getNextToken() {
        return nextToken;
    }
    
    /**
     * The <code>nextToken</code> value to include in a future
     * <code>ListTasks</code> request. When the results of a
     * <code>ListTasks</code> request exceed <code>maxResults</code>, this
     * value can be used to retrieve the next page of results. This value is
     * <code>null</code> when there are no more results to return.
     *
     * @param nextToken The <code>nextToken</code> value to include in a future
     *         <code>ListTasks</code> request. When the results of a
     *         <code>ListTasks</code> request exceed <code>maxResults</code>, this
     *         value can be used to retrieve the next page of results. This value is
     *         <code>null</code> when there are no more results to return.
     */
    public void setNextToken(String nextToken) {
        this.nextToken = nextToken;
    }
    
    /**
     * The <code>nextToken</code> value to include in a future
     * <code>ListTasks</code> request. When the results of a
     * <code>ListTasks</code> request exceed <code>maxResults</code>, this
     * value can be used to retrieve the next page of results. This value is
     * <code>null</code> when there are no more results to return.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param nextToken The <code>nextToken</code> value to include in a future
     *         <code>ListTasks</code> request. When the results of a
     *         <code>ListTasks</code> request exceed <code>maxResults</code>, this
     *         value can be used to retrieve the next page of results. This value is
     *         <code>null</code> when there are no more results to return.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public ListTasksResult withNextToken(String nextToken) {
        this.nextToken = nextToken;
        return this;
    }

    /**
     * Returns a string representation of this object; useful for testing and
     * debugging.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getTaskArns() != null) sb.append("TaskArns: " + getTaskArns() + ",");
        if (getNextToken() != null) sb.append("NextToken: " + getNextToken() );
        sb.append("}");
        return sb.toString();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;
        
        hashCode = prime * hashCode + ((getTaskArns() == null) ? 0 : getTaskArns().hashCode()); 
        hashCode = prime * hashCode + ((getNextToken() == null) ? 0 : getNextToken().hashCode()); 
        return hashCode;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (obj instanceof ListTasksResult == false) return false;
        ListTasksResult other = (ListTasksResult)obj;
        
        if (other.getTaskArns() == null ^ this.getTaskArns() == null) return false;
        if (other.getTaskArns() != null && other.getTaskArns().equals(this.getTaskArns()) == false) return false; 
        if (other.getNextToken() == null ^ this.getNextToken() == null) return false;
        if (other.getNextToken() != null && other.getNextToken().equals(this.getNextToken()) == false) return false; 
        return true;
    }
    
}
    