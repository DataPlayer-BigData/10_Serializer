package tu.cit.example.JsonSerializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.smile.SmileFactory;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class StudentJsonDeserializerBinary implements Deserializer {
    private static ObjectMapper objectMapper = new ObjectMapper(new SmileFactory());
    //private static Logger log = LogManager.getLogger();
    public void configure(Map configs, boolean isKey) {

    }

    public Object deserialize(String s, byte[] bytes) {
        StudentModel student = null;
        try{
            student = objectMapper.readValue(bytes,StudentModel.class);
        }catch(Exception e){
            //log.error("unable to deserialize {}",bytes,e);
        }
        return student;
    }

    public void close() {

    }
}
