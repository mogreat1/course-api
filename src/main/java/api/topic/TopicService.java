package api.topic;

import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Optional<Topic> getTopic(String id) {
        Optional<Topic> topic = topicRepository.findById(id);

        return topic;
    }

    public String addTopic(Topic topic) {
        topicRepository.save(topic);
        return "Success!";
    }

    public String updateTopic(String id, Topic topic) {
        topicRepository.save(topic);
        return "Success!";

    }

    public String deleteTopic(String id) {
        // topics.removeIf(topic -> topic.getId().equals(id));
        topicRepository.deleteById(id);
        return "Success!";

    }
    //https://github.com/dailylearning/spring-boot-quick-start/blob/master/pom.xml
    //https://www.youtube.com/playlist?list=PLqq-6Pq4lTTbx8p2oCgcAQGQyqN8XeA1x


}
