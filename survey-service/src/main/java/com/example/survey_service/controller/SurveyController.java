package com.example.survey_service.controller;

import com.example.survey_service.entity.Survey;
import com.example.survey_service.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hw3/surveys")
public class SurveyController {

    @Autowired
    private SurveyRepository surveyRepository;

    // Create a new survey
    @PostMapping
    public Survey createSurvey(@RequestBody Survey survey) {
        return surveyRepository.save(survey);
    }

    // Retrieve all surveys
    @GetMapping
    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    // Retrieve a survey by ID
    @GetMapping("/{id}")
    public Survey getSurveyById(@PathVariable Long id) {
        Optional<Survey> survey = surveyRepository.findById(id);
        return survey.orElse(null); // Return null if not found
    }

    // Update a survey by ID
    @PutMapping("/{id}")
    public Survey updateSurvey(@PathVariable Long id, @RequestBody Survey updatedSurvey) {
        // Check if the survey exists
        Optional<Survey> existingSurvey = surveyRepository.findById(id);

        if (existingSurvey.isPresent()) {
            // Copy the fields from the updatedSurvey to the existing one
            Survey survey = existingSurvey.get();

            // Update non-ID fields
            survey.setFirstName(updatedSurvey.getFirstName());
            survey.setLastName(updatedSurvey.getLastName());
            survey.setStreetAddress(updatedSurvey.getStreetAddress());
            survey.setCity(updatedSurvey.getCity());
            survey.setState(updatedSurvey.getState());
            survey.setZip(updatedSurvey.getZip());
            survey.setTelephoneNumber(updatedSurvey.getTelephoneNumber());
            survey.setEmail(updatedSurvey.getEmail());
            survey.setSurveyDate(updatedSurvey.getSurveyDate());
            survey.setLikedMost(updatedSurvey.getLikedMost());
            survey.setInterestSource(updatedSurvey.getInterestSource());
            survey.setLikelihoodRecommendation(updatedSurvey.getLikelihoodRecommendation());

            // Save the updated survey
            return surveyRepository.save(survey);
        }

        return null; // Return null if survey doesn't exist
    }

    // Delete a survey by ID
    @DeleteMapping("/{id}")
    public void deleteSurvey(@PathVariable Long id) {
        surveyRepository.deleteById(id);
    }
}
