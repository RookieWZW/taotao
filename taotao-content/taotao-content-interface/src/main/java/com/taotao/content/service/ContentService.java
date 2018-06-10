package com.taotao.content.service;

import java.util.List;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

public interface ContentService {
	
	
	TaotaoResult addContent(TbContent content);
	
	TaotaoResult updateContent(TbContent content);
	
	TaotaoResult deleteContent(TbContent content);
	
	
	List<TbContent> getContentByCid(Long cid);
	
}
