package tu.cit.example.JsonSerializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.smile.SmileFactory;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class StudentJsonDeserializerBinaryPrint implements Deserializer {
    private static ObjectMapper objectMapper = new ObjectMapper(new SmileFactory());
    //private static Logger log = LogManager.getLogger();
    public void configure(Map configs, boolean isKey) {

    }

    public String deserialize(String s, byte[] bytes) {
        StudentModel student = new StudentModel();
        try{
            student = objectMapper.readValue(bytes,StudentModel.class);
        }catch(Exception e){
            //log.error("unable to deserialize {}",bytes,e);
        }

        //assert student != null;
        if(student == null){
            student.setStudentid(0);
            student.setStudentname("NA");
            student.setDept("NA");
            student.setCoursename("NA");
            student.setMarks(0.0);;
        }

        return student.toString();
    }

    public void close() {

    }
}
