package com.kafka.apachekafka.Controller;


import com.kafka.apachekafka.kafka.JsonKafkaProducer;
import com.kafka.apachekafka.kafka.KafkaProducer;
import com.kafka.apachekafka.payload.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    private KafkaProducer kafkaProducer;
    private JsonKafkaProducer jsonKafkaProducer;


    @Autowired
    public MessageController( KafkaProducer kafkaProducer , JsonKafkaProducer jsonKafkaProducer) {
        this.kafkaProducer = kafkaProducer;
        this.jsonKafkaProducer = jsonKafkaProducer;
    }


//


    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        this.kafkaProducer.sendMessage(message);
        return new ResponseEntity<>("Message is sent",HttpStatus.OK);
    }

    @PostMapping("/jsonPublish")
    public ResponseEntity<String> publish(@RequestBody User message) {
        this.jsonKafkaProducer.sendMessage(message);
        return new ResponseEntity<>("Message is sent",HttpStatus.OK);
    }




}
