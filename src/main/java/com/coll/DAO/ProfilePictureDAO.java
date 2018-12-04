package com.coll.DAO;
import com.coll.Model.ProfilePicture;

public interface ProfilePictureDAO {

	public void save(ProfilePicture profilePicture);
	public ProfilePicture getProfilePicture(String loginname);
}

