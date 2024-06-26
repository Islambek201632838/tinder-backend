package com.discord.backend.profileService.controller;

import com.discord.backend.profileService.model.Profile;
import com.discord.backend.profileService.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping
    public ResponseEntity<List<Profile>> getAllProfiles() {
        List<Profile> profiles = profileService.getAllProfiles();
        return ResponseEntity.ok(profiles);
    }

    @PostMapping
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile) {
        Profile createdProfile = profileService.saveOrUpdateProfile(profile);
        return new ResponseEntity<>(createdProfile, HttpStatus.CREATED);
    }
    @PutMapping("/updateUniversity/{id}")
    public ResponseEntity<Profile> updateUniversity(@PathVariable String id, @RequestBody String university) {
        Profile updatedProfile = profileService.updateUniversity(id, university);
        return new ResponseEntity<>(updatedProfile, HttpStatus.OK);
    }

    @PutMapping("/updateBuddy/{id}")
    public ResponseEntity<Profile> updateBuddy(@PathVariable String id, @RequestBody String buddy) {
        Profile updatedProfile = profileService.updateBuddy(id, buddy);
        return new ResponseEntity<>(updatedProfile, HttpStatus.OK);
    }
}
