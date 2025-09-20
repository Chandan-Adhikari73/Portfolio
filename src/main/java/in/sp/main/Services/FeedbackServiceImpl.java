package in.sp.main.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.entities.Feedback;
import in.sp.main.repository.FeedbackRepository;

@Service
public class FeedbackServiceImpl implements FeedbackServices {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public boolean addStudentDetails(Feedback fd) {
        try {
            feedbackRepository.save(fd);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }
}
