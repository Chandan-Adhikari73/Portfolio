package in.sp.main.Services;

import java.util.List;

import in.sp.main.entities.Feedback;

public interface FeedbackServices {
    
    boolean addStudentDetails(Feedback fd);

	List<Feedback> getAllFeedback();
}
