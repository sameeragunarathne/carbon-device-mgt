/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

function onRequest(context) {
    var devices = context.unit.params.devices;
    var deviceType = context.uriParams.deviceType;
    var deviceId = request.getParameter("deviceId");

    if (devices) {
        return {
            "devices": stringify(devices),
            "backendApiUri":  "/android_sense/stats/"
        };
    } else if (deviceType != null && deviceType != undefined && deviceId != null && deviceId != undefined) {
        var deviceModule = require("/app/modules/business-controllers/device.js")["deviceModule"];
        var device = deviceModule.viewDevice(deviceType, deviceId);
        if (device && device.status != "error") {
            return {
                "device": device.content,
                "backendApiUrl":  "/android_sense/stats/" + deviceId + "/sensors/"
            };
        } else {
            response.sendError(404, "Device Id " + deviceId + " of type " + deviceType + " cannot be found!");
            exit();
        }
    }
}