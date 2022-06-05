package course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import topic.Topic;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;
    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id){
        return courseService.getAllCourses(id);
    }

    @RequestMapping("/topics/{topicid}/courses/{id}")
    public Optional<Course> getCourse(@PathVariable String id)
    {
        return courseService.getCourse(id);
    }
    
    @RequestMapping(method= RequestMethod.POST, value= "/topics/{topicid}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId){
        course.setTopic(new Topic(topicId,"", ""));
        courseService.addCourse(course);
    }

    @RequestMapping(method= RequestMethod.PUT, value= "/topics/{topicid}/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String id, @PathVariable String topicId){
        course.setTopic(new Topic(topicId,"", ""));
        courseService.updateCourse(course);
    }

    @RequestMapping(method= RequestMethod.DELETE, value="/topics/{topicid}/courses/{id}")
    public void deleteTopics(@PathVariable String id)
    {
        courseService.deleteCourse(id);
    }

}
