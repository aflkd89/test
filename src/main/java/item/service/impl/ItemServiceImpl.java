package item.service.impl;

import java.util.List;
import java.util.UUID;

import item.dao.ItemDao;
import item.dto.Item;
import item.service.ItemService;

public class ItemServiceImpl implements ItemService{
	
	private ItemDao itemDao;
	public ItemServiceImpl(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	//상품 리스트 
	@Override
	public List<Item> itemList(Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	//상품 등록
	@Override
	public int itemRegister(Item item) {
		UUID one = UUID.randomUUID();
		item.setItemCode(one.toString());
		//폼에서 상품명, 설명, 가격, 재고 넘어옴

		System.out.println("itemRegister 진입 / UUID :  " + item.getItemCode().toString());
		
		return itemDao.insert(item);
	}

	//상품 설명 수정
	@Override
	public boolean itemModify(Item item) {

		return false;
	}

}
