package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

//    @Transactional
//    public Item updateItem(Long itemId, Book param) {
//        Item findItem = itemRepository.findOne(itemId); // id를 기반으로 실제 DB에 있는 영속 상태 엔티티를 찾아옴.
////        findItem.change(price, name, stockQuantity); 실제론 setter 호출이 아닌 의미있는 메서드 생성하여 변경 -> 변경 지점이 엔티티로 다 갈 수 O
//        findItem.setPrice(param.getPrice());
//        findItem.setName(param.getName());
//        findItem.setStockQuantity(param.getStockQuantity());
////        itemRepository.save(findItem); em.persist()나 em.merge() 호출할 필요 X
//        return findItem;
//    }

    @Transactional
    public void updateItem(Long itemId, String name, int price, int stockQuantity) {
        Item findItem = itemRepository.findOne(itemId); // id를 기반으로 실제 DB에 있는 영속 상태 엔티티를 찾아옴.
        findItem.setPrice(price);
        findItem.setName(name);
        findItem.setStockQuantity(stockQuantity);
    }


    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
}
