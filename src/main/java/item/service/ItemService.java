package item.service;

import java.util.List;

import item.dto.Item;

public interface ItemService {

	//상품 조회
	List<Item> itemList(Item item);	
	//상품 등록
	int itemRegister(Item item);
	//수정
	boolean itemModify(Item item);
}
