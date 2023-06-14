package com.pc.pcsearch.services;

import com.pc.pcsearch.models.buildpc.BuildPC;
import com.pc.pcsearch.models.buildpc.Like;
import com.pc.pcsearch.models.buildpc.User;

public interface PublicLikeService {

    public boolean isLiked(BuildPC buildPC, User user);

    public Like putLike(BuildPC buildPC, User user);

    public void removeLike(BuildPC buildPC, User user);
}
