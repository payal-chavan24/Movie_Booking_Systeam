package com.tka.service;

import java.util.List;

import com.tka.entity.Show;

public interface ShowService {
	Show saveShow(Show show);

	List<Show> getAllShow();

	Show getShowById(Long id);

	void deleteById(Long id);
	
	Show updateShow(Long id,Show show);
}
