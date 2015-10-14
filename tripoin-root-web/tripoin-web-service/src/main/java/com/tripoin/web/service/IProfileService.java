package com.tripoin.web.service;

import com.tripoin.core.dto.ProfileData;
import com.tripoin.core.dto.UserData;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public interface IProfileService {

    public ProfileData getProfile();
    public String saveProfile(ProfileData profileData, UserData userData);
    public String updateProfile(ProfileData profileData, UserData userData);

}
