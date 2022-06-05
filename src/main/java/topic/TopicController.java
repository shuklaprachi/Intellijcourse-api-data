package topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;
    @GetMapping ("/topics")
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }

    @RequestMapping("/topics/{id}")
    public Optional<Topic> getTopics(@PathVariable String id)
    {
        return topicService.getTopic(id);
    }
    
    @RequestMapping(method= RequestMethod.POST, value= "/topics")
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

    @RequestMapping(method= RequestMethod.PUT, value= "/topics/{id}")
    public void addTopic(@RequestBody Topic topic, @PathVariable String id){
        topicService.updateTopic(topic, id);
    }

    @RequestMapping(method= RequestMethod.DELETE, value="/topics/{id}")
    public void deleteTopics(@PathVariable String id)
    {
        topicService.delete(id);
    }

}
