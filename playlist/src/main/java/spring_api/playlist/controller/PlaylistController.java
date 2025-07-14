package spring_api.playlist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import spring_api.playlist.service.PlaylistService;

@RestController
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;


}
