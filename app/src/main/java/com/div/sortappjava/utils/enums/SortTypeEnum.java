package com.div.sortappjava.utils.enums;

import com.div.sortappjava.R;
import com.div.sortappjava.ui.fragments.fragments.SortTypeFragment;
import com.div.sortappjava.utils.Constants;

/**
 * Created by arioch666 on 11/14/17.
 */

public enum SortTypeEnum {
    QUICK_SORT(Constants.SortAlgorithmType.QUICK_SORT, R.string.quick_sort),
    SELECTION_SORT(Constants.SortAlgorithmType.SELECTION_SORT, R.string.selection_sort),
//    MERGE_SORT(Constants.SortAlgorithmType.MERGE_SORT, R.string.merge_sort),
    INSERTION_SORT(Constants.SortAlgorithmType.INSERTION_SORT, R.string.insertion_sort);

    private final int value;
    private final int stringResId;

    SortTypeEnum(int value, int stringResId) {
        this.value = value;
        this.stringResId = stringResId;
    }

    public static SortTypeEnum enumFromValue(int value) {
        for (SortTypeEnum sortTypeEnum :
                SortTypeEnum.values()) {
            if (sortTypeEnum.value == value) {
                return sortTypeEnum;
            }
        }
        return SortTypeEnum.QUICK_SORT;
    }

    public int getValue() {
        return value;
    }

    public int getStringResId() {
        return stringResId;
    }
}
