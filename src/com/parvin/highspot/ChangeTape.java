package com.parvin.highspot;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChangeTape {

	@JsonProperty("RemovePlaylist")
	Playlist[] RemovePlaylist;
	@JsonProperty("CreatePlaylist")
	Playlist[] CreatePlaylist;
	@JsonProperty("AddSong")
	Playlist[] AddSong;
	
	ChangeTape(){
		
	}

	public Playlist[] getRemovePlaylist() {
		return RemovePlaylist;
	}

	public void setRemovePlaylist(Playlist[] removePlaylist) {
		RemovePlaylist = removePlaylist;
	}

	public Playlist[] getCreatePlaylist() {
		return CreatePlaylist;
	}

	public void setCreatePlaylist(Playlist[] createPlaylist) {
		CreatePlaylist = createPlaylist;
	}

	public Playlist[] getAddSong() {
		return AddSong;
	}

	public void setAddSong(Playlist[] addSong) {
		AddSong = addSong;
	}
	
}
