package cn.e3mall.service;

import java.util.List;

import xn.e3mall.common.pojo.EasyUITreeNode;

public interface ItemCatService {
	
	List<EasyUITreeNode> getItemCat(long parentId);
}
