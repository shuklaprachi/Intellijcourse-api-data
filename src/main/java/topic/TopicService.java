package topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TopicService {
    @Autowired
    public TopicRepository topicRepository;

   private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring", "Spring Framework", "Spring Framework Description"),
                new Topic("java", "Core Java", "Core Java Description"),
                new Topic("javascript", "javascript", "javascript Description")
                ));
    /*public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }*/

    public List<Topic> getAllTopics(){

       //return topics;
       List<Topic> topics=new ArrayList<>();
       topicRepository.findAll()
               .forEach(topics::add);
       return topics;
   }
   public Optional<Topic> getTopic(String id) {

       //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return topicRepository.findById(id);
   }
   public void addTopic(Topic topic){
       //topics.add(topic);
       topicRepository.save(topic);
   }

    public void updateTopic(Topic topic, String id) {
       topicRepository.save(topic);
    }

    public void delete(String id) {

       //topics.removeIf(t -> t.getId().equals(id));
        topicRepository.deleteById(id);
    }
}
