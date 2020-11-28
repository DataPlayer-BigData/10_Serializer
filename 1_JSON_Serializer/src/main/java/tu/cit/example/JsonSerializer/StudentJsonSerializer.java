package tu.cit.example.JsonSerializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class StudentJsonSerializer implements Serializer {
    private final ObjectMapper objectMapper = new ObjectMapper();
    public void configure(Map configs, boolean isKey) {
        //nothing to configure in this example
    }

    public byte[] serialize(String topic, Object data) {
        if(data == null)
            return null;
        try{
            return objectMapper.writeValueAsBytes(data);
        }catch(Exception e){
            throw new SerializationException("Error while serializing data...",e);
        }
    }

    public void close() {
        System.out.println("This close() method of serializer is called at the end of the kafka session.");
    }
}
