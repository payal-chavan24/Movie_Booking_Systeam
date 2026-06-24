package com.tka.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.entity.Show;
import com.tka.reposistory.ShowReposisitory;
import com.tka.service.ShowService;

@Service
public class ShowServiceimple implements ShowService {
	@Autowired
	ShowReposisitory showReposisitory;

	@Override
	public Show saveShow(Show show) {
		return showReposisitory.save(show);

	}

	@Override
	public List<Show> getAllShow() {
		return showReposisitory.findAll();
	}

	@Override
	public Show getShowById(Long id) {
		return showReposisitory.getById(id);
	}

	@Override
	public void deleteById(Long id) {
		showReposisitory.deleteById(id);
	}

	@Override
	public Show updateShow(Long id, Show show) {
		Show existingShow = showReposisitory.findById(id).orElse(null);
		if (existingShow != null) {
			existingShow.setAvailableSeats(show.getAvailableSeats());
			existingShow.setShowDate(show.getShowDate());
			existingShow.setShowId(show.getShowId());
			existingShow.setShowTime(show.getShowTime());
			existingShow.setTicketPrice(show.getTicketPrice());
			return existingShow;

		}
		return null;

	}

}
