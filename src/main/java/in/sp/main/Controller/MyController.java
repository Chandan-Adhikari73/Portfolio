package in.sp.main.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import in.sp.main.entities.Feedback;
import in.sp.main.Services.FeedbackServices;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins = "http://localhost:3000") // React frontend ke liye
public class MyController {

    @Autowired
    private FeedbackServices feedbackServices;

    @PostMapping
    public String saveFeedback(@RequestBody Feedback feedback) {
        boolean status = feedbackServices.addStudentDetails(feedback);
        if (status) {
            return "Feedback Saved Successfully ✅";
        } else {
            return "Failed to Save Feedback ❌";
        }
    }

    // (optional) sabhi feedbacks dekhne ke liye
    @GetMapping
    public java.util.List<Feedback> getAllFeedback() {
        return ((in.sp.main.Services.FeedbackServiceImpl) feedbackServices).getAllFeedback();
    }
}
