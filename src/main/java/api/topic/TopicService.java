package api.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        //return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
        return topicRepository.findById(id);
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
        topicRepository.save(topic);
       /* for (int i = 0; i < topics.size(); i++) {
            Topic topic1 = topics.get(i);
            if (topic1.getId().equals(id)) {
                topics.set(i, topic);
                return;
            }
        }*/
    }

    public void deleteTopic(String id) {
        // topics.removeIf(topic -> topic.getId().equals(id));
        topicRepository.deleteById(id);

    }
    //https://github.com/dailylearning/spring-boot-quick-start/blob/master/pom.xml
    //https://www.youtube.com/playlist?list=PLqq-6Pq4lTTbx8p2oCgcAQGQyqN8XeA1x


}
