package com.parvin.highspot;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Album {

	@JsonProperty("users")
	Users[] users;
	@JsonProperty("playlists")
	Playlist[] playlists;
	@JsonProperty("songs")
	Song[] songs;
	
	public Album() {
		
	}
	
	public Users[] getUsers() {
		return users;
	}
	public void setUsers(Users[] users) {
		this.users = users;
	}
	public Playlist[] getPlaylists() {
		return playlists;
	}
	public void setPlaylists(Playlist[] playlists) {
		this.playlists = playlists;
	}
	public Song[] getSongs() {
		return songs;
	}
	public void setSongs(Song[] songs) {
		this.songs = songs;
	}
	
}
