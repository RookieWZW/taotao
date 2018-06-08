
package com.taotao.service.impl;
/**
 * 
 * @author RookieWZW
 *
 */

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.IDUtils;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;

	@Autowired
	private TbItemDescMapper itemDescMapper;

	@Override
	public TbItem getItemById(Long itemId) {
		TbItem item = itemMapper.selectByPrimaryKey(itemId);
		return item;
	}

	@Override
	public EasyUIDataGridResult getItemList(int page, int rows) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, rows);

		TbItemExample example = new TbItemExample();

		List<TbItem> list = itemMapper.selectByExample(example);

		PageInfo<TbItem> pageInfo = new PageInfo<>(list);

		EasyUIDataGridResult result = new EasyUIDataGridResult();

		result.setRows(list);

		result.setTotal(pageInfo.getTotal());

		return result;
	}

	@Override
	public TaotaoResult addItem(TbItem item, String desc) {
		// TODO Auto-generated method stub
		long itemId = IDUtils.getItemId();

		item.setId(itemId);

		item.setStatus((byte) 1);

		item.setCreated(new Date());

		item.setUpdated(new Date());

		itemMapper.insert(item);

		TbItemDesc itemDesc = new TbItemDesc();

		itemDesc.setItemId(itemId);
		itemDesc.setItemDesc(desc);
		itemDesc.setUpdated(new Date());
		itemDesc.setCreated(new Date());

		itemDescMapper.insert(itemDesc);

		return TaotaoResult.ok();

	}

}
