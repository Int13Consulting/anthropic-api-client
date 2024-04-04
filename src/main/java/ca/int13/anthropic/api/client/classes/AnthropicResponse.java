/*
Copyright (c) 2024 Int13 Consulting Inc.

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
"Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
package ca.int13.anthropic.api.client.classes;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/**
 *
 * @author mgamble
 */
public class AnthropicResponse {
    private ArrayList<AnthropicContent> content;
    private String id;
    private String model;
    private String role;
    @SerializedName("stop_reason")
    private String stopReason;
    @SerializedName("stop_sequence")
    private String stopSequence;
    private String type;
    private AnthropicUsage usage;  

    /**
     * @return the content
     */
    public ArrayList<AnthropicContent> getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(ArrayList<AnthropicContent> content) {
        this.content = content;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return the stopReason
     */
    public String getStopReason() {
        return stopReason;
    }

    /**
     * @param stopReason the stopReason to set
     */
    public void setStopReason(String stopReason) {
        this.stopReason = stopReason;
    }

    /**
     * @return the stopSequence
     */
    public String getStopSequence() {
        return stopSequence;
    }

    /**
     * @param stopSequence the stopSequence to set
     */
    public void setStopSequence(String stopSequence) {
        this.stopSequence = stopSequence;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the usage
     */
    public AnthropicUsage getUsage() {
        return usage;
    }

    /**
     * @param usage the usage to set
     */
    public void setUsage(AnthropicUsage usage) {
        this.usage = usage;
    }
}
