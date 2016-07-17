
package eapearsonuitestmodule;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * <p>Original spec-file type: TestResult</p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "message",
    "elapsed"
})
public class TestResult {

    @JsonProperty("message")
    private String message;
    @JsonProperty("elapsed")
    private Long elapsed;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    public TestResult withMessage(String message) {
        this.message = message;
        return this;
    }

    @JsonProperty("elapsed")
    public Long getElapsed() {
        return elapsed;
    }

    @JsonProperty("elapsed")
    public void setElapsed(Long elapsed) {
        this.elapsed = elapsed;
    }

    public TestResult withElapsed(Long elapsed) {
        this.elapsed = elapsed;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperties(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return ((((((("TestResult"+" [message=")+ message)+", elapsed=")+ elapsed)+", additionalProperties=")+ additionalProperties)+"]");
    }

}
