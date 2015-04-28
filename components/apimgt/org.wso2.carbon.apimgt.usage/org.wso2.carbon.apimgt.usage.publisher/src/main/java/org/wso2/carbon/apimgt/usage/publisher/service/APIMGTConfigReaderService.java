/*
*  Copyright (c) 2005-2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/
package org.wso2.carbon.apimgt.usage.publisher.service;

import org.apache.axis2.util.JavaUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.apimgt.impl.APIManagerConfiguration;
import org.wso2.carbon.apimgt.impl.APIConstants;
import org.wso2.carbon.apimgt.usage.publisher.APIMgtUsagePublisherConstants;

public class APIMGTConfigReaderService {

    private String bamServerThriftPort;
    private String bamServerURL;
    private String bamServerUser;
    private String bamServerPassword;
    private boolean enabled;
    private boolean buildMsg;
    private String publisherClass;
    private boolean googleAnalyticsTrackingEnabled;
    private String googleAnalyticsTrackingID;
	private String requestStreamName;
	private String requestStreamVersion;
	private String responseStreamName;
	private String responseStreamVersion;
	private String faultStreamName;
	private String faultStreamVersion;
    private String throttleStreamName;
	private String throttleStreamVersion;
	private static Log log = LogFactory.getLog(APIMGTConfigReaderService.class);

    public APIMGTConfigReaderService(APIManagerConfiguration config) {
        String enabledStr = config.getFirstProperty(APIConstants.API_USAGE_ENABLED);
        enabled = enabledStr != null && JavaUtils.isTrueExplicitly(enabledStr);
        bamServerThriftPort = config.getFirstProperty(APIConstants.API_USAGE_THRIFT_PORT);
        bamServerURL = config.getFirstProperty(APIConstants.API_USAGE_BAM_SERVER_URL);
        bamServerUser = config.getFirstProperty(APIConstants.API_USAGE_BAM_SERVER_USER);
        bamServerPassword = config.getFirstProperty(APIConstants.API_USAGE_BAM_SERVER_PASSWORD);
        publisherClass = config.getFirstProperty(APIConstants.API_USAGE_PUBLISHER_CLASS);
        requestStreamName =
			    config.getFirstProperty(APIMgtUsagePublisherConstants.API_REQUEST_STREAM_NAME);
	    requestStreamVersion =
			    config.getFirstProperty(APIMgtUsagePublisherConstants.API_REQUEST_STREAM_VERSION);
	    if (requestStreamName == null || requestStreamVersion == null) {
		    log.error("Request stream name or version is null. Check api-manager.xml");
	    }
	    responseStreamName =
			    config.getFirstProperty(APIMgtUsagePublisherConstants.API_RESPONSE_STREAM_NAME);
	    responseStreamVersion =
			    config.getFirstProperty(APIMgtUsagePublisherConstants.API_RESPONSE_STREAM_VERSION);
	    if (responseStreamName == null || responseStreamVersion == null) {
		    log.error("Response stream name or version is null. Check api-manager.xml");
	    }
	    faultStreamName =
			    config.getFirstProperty(APIMgtUsagePublisherConstants.API_FAULT_STREAM_NAME);
	    faultStreamVersion =
			    config.getFirstProperty(APIMgtUsagePublisherConstants.API_FAULT_STREAM_VERSION);
	    if (faultStreamName == null || faultStreamVersion == null) {
		    log.error("Fault stream name or version is null. Check api-manager.xml");
	    }
        throttleStreamName =
                config.getFirstProperty(APIMgtUsagePublisherConstants.API_THROTTLE_STREAM_NAME);
        throttleStreamVersion =
                config.getFirstProperty(APIMgtUsagePublisherConstants.API_THRORRLE_STREAM_VERSION);
        if (throttleStreamName == null || throttleStreamVersion == null) {
            log.error("Throttle stream name or version is null. Check api-manager.xml");
        }
        String build = config.getFirstProperty(APIConstants.API_USAGE_BUILD_MSG);
        buildMsg = build != null && JavaUtils.isTrueExplicitly(build);
    }

    public String getBamServerThriftPort() {
        return bamServerThriftPort;
    }

    public String getBamServerPassword() {
        return bamServerPassword;
    }

    public String getBamServerUser() {
        return bamServerUser;
    }

    public String getBamServerURL() {
        return bamServerURL;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getPublisherClass() {
        return publisherClass;
    }
     
    public String getGoogleAnalyticsTrackingID() {
 		return googleAnalyticsTrackingID;
 	}

    public boolean isGoogleAnalyticsTrackingEnabled() {
    	return googleAnalyticsTrackingEnabled;
    }

	public String getRequestStreamName() {
		return requestStreamName;
	}

	public String getRequestStreamVersion() {
		return requestStreamVersion;
	}

	public String getResponseStreamName() {
		return responseStreamName;
	}

	public String getResponseStreamVersion() {
		return responseStreamVersion;
	}

	public String getFaultStreamName() {
		return faultStreamName;
	}

	public String getFaultStreamVersion() {
		return faultStreamVersion;
	}

    public String getThrottleStreamName() {
        return throttleStreamName;
    }

    public String getThrottleStreamVersion() {
        return throttleStreamVersion;
    }

    public boolean isBuildMsg() {
        return buildMsg;
    }



}