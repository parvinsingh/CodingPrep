package com.parvin.highspot;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class to handle the modification for the Playlists
 * 1- Add song to existing playlist
 * 2- Create a new Playlist with atleast one song
 * 3- Delete a playlist belonging to a user
 */
public class ModifyPlaylist {

	static HashMap<String, Playlist> playlistIdMap = new HashMap<String, Playlist>();
	static HashMap<String, LinkedList<String>> userPlaylistIdMap = new HashMap<String, LinkedList<String>>();
	
	
	ModifyPlaylist(Playlist[] playlist){
		for(Playlist pl: playlist) {
			playlistIdMap.put(pl.getId(), pl);
			
			LinkedList<String> values = userPlaylistIdMap.getOrDefault(pl.getUser_id(), new LinkedList<String>());
			values.add(pl.getId());
			userPlaylistIdMap.put(pl.getUser_id(), values);
		}
	}
	

	public void AddSong(Playlist[] playlists) {
		for(Playlist newpl: playlists) {
			if(playlistIdMap.containsKey(newpl.getId())) {
				Playlist p = playlistIdMap.get(newpl.getId());
				List<String> songs = Arrays.asList(p.getSong_ids());
				List<String> newSongs = Arrays.asList(newpl.getSong_ids());
				
				List<String> newList = Stream.concat(songs.stream(), newSongs.stream())
                        .collect(Collectors.toList());
				
				p.setSong_ids(newList.toArray(new String[0]));
			}else {
				createOnePlaylist(newpl);
			}
		}
	}
	
	//only removes the playlist by userId
	public void Remove(Playlist[] playlists) {
		for(Playlist pl: playlists) {
			if(pl.getUser_id() != null) {
				List<String> plIds = userPlaylistIdMap.remove(pl.getUser_id());
				for(String s : plIds) {
					playlistIdMap.remove(s);
				}
			}
		}
	}
	
	public void Create(Playlist[] playlists) {
		//filter out any playlist that does not have a song
		Arrays.stream(playlists).filter(p -> p.getSong_ids()!=null).toArray();
		
		for(Playlist pl: playlists) {
			createOnePlaylist(pl);
		}
	}


	private void createOnePlaylist(Playlist pl) {
		pl.setId(generateId());
		playlistIdMap.put(pl.getId(), pl);
	}
		
	//should be coming from a playlistID generation service
	private String generateId() {
		Random r = new Random();
		
		int newId = r.nextInt(101)+1;
		while(playlistIdMap.containsKey(newId)) {
			newId = r.nextInt(101)+1;
		}
		return String.valueOf(newId);
	}
	
	public Playlist[] getUpdatedList() {
		Collection<Playlist> values = playlistIdMap.values();
	    return values.toArray(new Playlist[0]);
	}
	
}
