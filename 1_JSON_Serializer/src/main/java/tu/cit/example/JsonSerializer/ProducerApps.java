package tu.cit.example.JsonSerializer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Properties;

public class ProducerApps {
    //private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092,localhost:9093,localhost:9094");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StudentJsonSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StudentJsonSerializerBinary.class.getName());



        KafkaProducer<String,StudentModel> producer = new KafkaProducer<String, StudentModel>(props);
        //logger.info("Producer is created.");
        StudentModel student = new StudentModel(4,"Mr.D","CE","RDBMS",90.0);
        ProducerRecord<String,StudentModel> record = new ProducerRecord<String, StudentModel>("student-topic-nokey",student);

        producer.send(record);
        //logger.info("Record has been sent to Kafka...");
        producer.flush();
        producer.close();
        //logger.info("Producer is closed...");

    }
}
