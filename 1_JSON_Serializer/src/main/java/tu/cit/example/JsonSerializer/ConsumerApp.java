package tu.cit.example.JsonSerializer;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.Properties;

public class ConsumerApp {
    //private static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092,localhost:9093,localhost:9094");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
        //props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,true);
        props.put(ConsumerConfig.CLIENT_ID_CONFIG,"Consumerapp-json-binary");
        props.put(ConsumerConfig.GROUP_ID_CONFIG,"myConsumerGroup");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        //props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StudentJsonDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StudentJsonDeserializerBinaryPrint.class.getName());

        props.put(ConsumerConfig.PARTITION_ASSIGNMENT_STRATEGY_CONFIG, StickyAssignor.class.getName());

        KafkaConsumer<String,StudentModel> consumer = new KafkaConsumer<String, StudentModel>(props);

        consumer.subscribe(Collections.singleton("student-topic-Binary"));

        while(true){
            ConsumerRecords<String,StudentModel> records = consumer.poll(5);
            for(ConsumerRecord<String,StudentModel> record :records){

                //System.out.println("Key : "+record.key() + " ,Partition : " +record.partition() + "StudentID : " +record.value().getStudentid() + " , StudentName :  " + record.value().getStudentname()
                //+ " , Dept : " + record.value().getDept() + " , CourseName : " + record.value().getCoursename() + " , Marks : " + record.value().getMarks());

                //for StudentJsonDeserializerBinaryPrint
                System.out.println("----------------testing---------");
                System.out.println(record.key() + " : Value : "+record.value());
            }
        }
    }
}
