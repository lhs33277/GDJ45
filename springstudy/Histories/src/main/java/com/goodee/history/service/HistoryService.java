package com.goodee.history.service;

import java.util.List;
import java.util.Map;

import com.goodee.history.domain.HistoryDTO;

public interface HistoryService {
	public List<HistoryDTO> findAllHistories();
	public List<HistoryDTO> findHistoryByQuery(Map<String, Object> map);
}
