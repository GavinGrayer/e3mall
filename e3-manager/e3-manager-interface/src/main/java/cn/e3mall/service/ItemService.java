package cn.e3mall.service;

import org.omg.CORBA.ORBPackage.InconsistentTypeCode;

import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemDesc;
import xn.e3mall.common.pojo.EasyUIDataGridResult;
import xn.e3mall.common.utils.E3Result;

public interface ItemService {
	public TbItem getItemById(long itemid);
	EasyUIDataGridResult getItemList(int page,int rows);
	E3Result addItem(TbItem item, String desc);
	TbItemDesc getItemDescById(long itemId);
}
