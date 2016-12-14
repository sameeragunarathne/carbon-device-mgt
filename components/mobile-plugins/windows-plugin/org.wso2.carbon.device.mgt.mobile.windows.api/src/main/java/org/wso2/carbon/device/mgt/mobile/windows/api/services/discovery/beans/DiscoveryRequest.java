/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * you may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.device.mgt.mobile.windows.api.services.discovery.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DiscoveryRequest")
@ApiModel(value = "DiscoveryRequest",
        description = "Discover request related information.")
@SuppressWarnings("unused")
public class DiscoveryRequest implements Serializable {

    @ApiModelProperty(name = "emailId", value = "User email address which is submitted to the workplace app" +
            " once sign in .", required = true)
    @XmlElement(name = "EmailAddress", required = true)
    private String emailId;

    @ApiModelProperty(name = "version", value = "OS version on the Windows Device.", required = true)
    @XmlElement(name = "RequestVersion")
    private String version;

    @ApiModelProperty(name = "deviceType", value = "Type of the Device(LapTop/Mobile Device).", required = true)
    @XmlElement(name = "DeviceType")
    private String deviceType;

    public String getEmailId() {
        return emailId;
    }

    public String getVersion() {
        return version;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }
}