package de.leon.Tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @GetMapping
    public List<Task> getTasks(){
        return taskRepository.findAll();
    }

    @PostMapping
    public void postTasks(@RequestBody Task task) {
        taskRepository.save(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTasks(@PathVariable Long id){
        taskRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> putTask(@RequestBody Task task, @PathVariable Long id){
        Optional<Task> optionalTask = taskRepository.findById(id);
        if(optionalTask.isPresent()) {
            Task task1 = optionalTask.get();
            task1.setTitle(task.getTitle());
            task1.setCompleted(task.isCompleted());
            taskRepository.save(task1);
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
