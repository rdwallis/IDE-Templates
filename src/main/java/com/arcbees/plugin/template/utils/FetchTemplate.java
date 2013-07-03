/**
 * Copyright 2013 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.arcbees.plugin.template.utils;

import com.jayway.restassured.RestAssured;

public class FetchTemplate implements Runnable {
    private String url;
    private String fetched;

    public FetchTemplate(String url) {
        this.url = url;
    }

    public void run() {
        this.fetched = fetch();
    }

    // TODO deal with errors
    private String fetch() {
        return RestAssured.get(url).asString();
    }
    
    public String getFetched() {
        return fetched;
    }
    
    public boolean hasErrors() {
        return false;
    }
    
    public String getFileName() {
        String fileName = url.replaceAll(".*/", "");
        return fileName;
    }
}