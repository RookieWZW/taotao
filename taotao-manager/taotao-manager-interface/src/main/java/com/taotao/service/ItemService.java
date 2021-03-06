package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

public interface ItemService {
	public TbItem getItemById(Long itemId) ;
	
	public EasyUIDataGridResult getItemList(int page,int rows);
	
	public TaotaoResult addItem(TbItem item,String desc);
	
}
