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
package com.amazonaws.services.cloudsearchv2.model;

import java.io.Serializable;

import com.amazonaws.AmazonWebServiceRequest;

/**
 * Container for the parameters to the {@link com.amazonaws.services.cloudsearchv2.AmazonCloudSearch#createDomain(CreateDomainRequest) CreateDomain operation}.
 * <p>
 * Creates a new search domain. For more information, see
 * <a href="http://docs.aws.amazon.com/cloudsearch/latest/developerguide/creating-domains.html"> Creating a Search Domain </a>
 * in the <i>Amazon CloudSearch Developer Guide</i> .
 * </p>
 *
 * @see com.amazonaws.services.cloudsearchv2.AmazonCloudSearch#createDomain(CreateDomainRequest)
 */
public class CreateDomainRequest extends AmazonWebServiceRequest implements Serializable {

    /**
     * A name for the domain you are creating. Allowed characters are a-z
     * (lower-case letters), 0-9, and hyphen (-). Domain names must start
     * with a letter or number and be at least 3 and no more than 28
     * characters long.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>3 - 28<br/>
     * <b>Pattern: </b>[a-z][a-z0-9\-]+<br/>
     */
    private String domainName;

    /**
     * A name for the domain you are creating. Allowed characters are a-z
     * (lower-case letters), 0-9, and hyphen (-). Domain names must start
     * with a letter or number and be at least 3 and no more than 28
     * characters long.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>3 - 28<br/>
     * <b>Pattern: </b>[a-z][a-z0-9\-]+<br/>
     *
     * @return A name for the domain you are creating. Allowed characters are a-z
     *         (lower-case letters), 0-9, and hyphen (-). Domain names must start
     *         with a letter or number and be at least 3 and no more than 28
     *         characters long.
     */
    public String getDomainName() {
        return domainName;
    }
    
    /**
     * A name for the domain you are creating. Allowed characters are a-z
     * (lower-case letters), 0-9, and hyphen (-). Domain names must start
     * with a letter or number and be at least 3 and no more than 28
     * characters long.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>3 - 28<br/>
     * <b>Pattern: </b>[a-z][a-z0-9\-]+<br/>
     *
     * @param domainName A name for the domain you are creating. Allowed characters are a-z
     *         (lower-case letters), 0-9, and hyphen (-). Domain names must start
     *         with a letter or number and be at least 3 and no more than 28
     *         characters long.
     */
    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }
    
    /**
     * A name for the domain you are creating. Allowed characters are a-z
     * (lower-case letters), 0-9, and hyphen (-). Domain names must start
     * with a letter or number and be at least 3 and no more than 28
     * characters long.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>3 - 28<br/>
     * <b>Pattern: </b>[a-z][a-z0-9\-]+<br/>
     *
     * @param domainName A name for the domain you are creating. Allowed characters are a-z
     *         (lower-case letters), 0-9, and hyphen (-). Domain names must start
     *         with a letter or number and be at least 3 and no more than 28
     *         characters long.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public CreateDomainRequest withDomainName(String domainName) {
        this.domainName = domainName;
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
        if (getDomainName() != null) sb.append("DomainName: " + getDomainName() );
        sb.append("}");
        return sb.toString();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;
        
        hashCode = prime * hashCode + ((getDomainName() == null) ? 0 : getDomainName().hashCode()); 
        return hashCode;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (obj instanceof CreateDomainRequest == false) return false;
        CreateDomainRequest other = (CreateDomainRequest)obj;
        
        if (other.getDomainName() == null ^ this.getDomainName() == null) return false;
        if (other.getDomainName() != null && other.getDomainName().equals(this.getDomainName()) == false) return false; 
        return true;
    }
    
}
    