package tu.cit.example.JsonSerializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.smile.SmileFactory;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class StudentJsonSerializerBinary implements Serializer {
    //supports two formats: JSON and Smile. It uses the excellent Jackson library to support these formats.
    // Smile is basically binary JSON. It is not as small and fast as Kryo (Smile still stores key-value pairs)
    //need to add dependency jackson-dataformat-smile to use SmileFactory()
    private final ObjectMapper objectMapper = new ObjectMapper(new SmileFactory());
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
