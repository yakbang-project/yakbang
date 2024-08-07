package com.example.yakbang.batch;

import com.example.yakbang.dto.pill.PillItemDTO;
import com.example.yakbang.service.pill.PillApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemReader;

import java.util.List;

@RequiredArgsConstructor
public class PillItemReader implements ItemReader<PillItemDTO> {
    private final PillApiService pillApiService;

    private int nextIdx = 0;
    private List<PillItemDTO> items;

    @Override
    public PillItemDTO read() throws  Exception {

        if (items == null) {
            List<PillItemDTO> pillItemData = pillApiService.findPillData();
            items = pillItemData;
        }

        PillItemDTO nextItemDTO = null;

        if (nextIdx < items.size()) {
            nextItemDTO = items.get(nextIdx);
            nextIdx++;
        } else {
            items = null;
            nextIdx = 0;
        }

        return nextItemDTO;
    }

}
