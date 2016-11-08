package com.pet.supplies.mapper;

import com.pet.supplies.domain.Address;
import com.pet.supplies.domain.CartItem;
import com.pet.supplies.domain.Category;
import com.pet.supplies.domain.Image;
import com.pet.supplies.domain.Orders;
import com.pet.supplies.domain.Product;

import com.pet.supplies.domain.AuthenticateUser;
import com.pet.supplies.model.AddressModel;
import com.pet.supplies.model.AuthenticateUserModel;
import com.pet.supplies.model.CartItemModel;
import com.pet.supplies.model.CategoryModel;
import com.pet.supplies.model.ImageModel;
import com.pet.supplies.model.OrdersModel;
import com.pet.supplies.model.ProductModel;
import com.pet.supplies.model.UserModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.util.CollectionUtils;

/**
 * ????
 * 
 * @version $Id:$
 * @author njanjyal //I removed copyrights
 */
public class EntityToModelMapper
{

   /**
    * TODO
    * 
    * @param categories
    * @return
    */
   public static List<CategoryModel> mapCategoryEntityToCategoryModel(List<Category> categories)
   {
      List<CategoryModel> categoryModels = new ArrayList<CategoryModel>();
      if (!CollectionUtils.isEmpty(categories))
      {
         categories.forEach(category -> {
            CategoryModel model = new CategoryModel();
            model.setId(category.getId());
            model.setCode(category.getCode());
            model.setName(category.getName());
            model.setProducts(mapProductEntityToProductModel(category.getProducts()));
            categoryModels.add(model);
         });
      }
      return categoryModels;
   }

   /**
    * TODO
    * 
    * @param products
    * @return
    */
   public static Set<ProductModel> mapProductEntityToProductModel(Set<Product> products)
   {
      Set<ProductModel> productModels = new HashSet<ProductModel>();
      if (!CollectionUtils.isEmpty(products))
      {
         products.forEach(product -> {
            ProductModel model = new ProductModel();
            model.setProductId(product.getId());
            model.setProductName(product.getName());
            model.setPrice(product.getPrice());
            model.setCurrency(product.getCurrency());
            model.setDesc(product.getDesc());
            model.setStatus(product.isStatus());
            model.setQuantity(product.getQuantity());
            model.setImageUrls(mapImageEntityToImageModel(product.getImageUrls()));
            productModels.add(model);
         });
      }
      return productModels;
   }

   /**
    * TODO
    * 
    * @param images
    * @return
    */
   public static Set<ImageModel> mapImageEntityToImageModel(Set<Image> images)
   {
      Set<ImageModel> imageModels = new HashSet<ImageModel>();
      if (!CollectionUtils.isEmpty(images))
      {
         images.forEach(image -> {
            ImageModel model = new ImageModel();
            model.setId(image.getImg_id());
            model.setName(image.getName());
            model.setUrl(image.getUrl());
            imageModels.add(model);
         });

      }
      return imageModels;
   }

   /**
    * TODO
    * 
    * @param user
    * @return
    */
   public static UserModel mapAuthenticateUserEntityToUserModel(AuthenticateUser user)
   {
      UserModel model = new UserModel();
      if (user != null)
      {
         model.setUserId(user.getUserId());
         model.setPhone(user.getPhone());
      }
      return model;
   }

   /**
    * TODO
    * 
    * @param authUser
    * @return
    */
   public static AuthenticateUserModel mapAuthenticateUserEntityToAuthenticateUserModel(AuthenticateUser authUser)
   {
      AuthenticateUserModel model = new AuthenticateUserModel();
      if (authUser != null)
      {
         model.setEmailId(authUser.getEmailId());
         model.setPhone(authUser.getPhone());
         model.setUserId(authUser.getUserId());
         model.setPassword(authUser.getPassword());
         model.setActive(authUser.isActive());
      }
      return model;
   }

   /**
    * TODO
    * 
    * @param items
    * @return
    */
   public static List<CartItemModel> mapCartItemEntitiesToCartItemModels(List<CartItem> items)
   {
      List<CartItemModel> models = new ArrayList<CartItemModel>();
      if (!CollectionUtils.isEmpty(items))
      {
         items.forEach(item -> {
            models.add(mapCartItemEntityToCartItemModel(item));
         });
      }
      return models;
   }

   /**
    * TODO
    * 
    * @param item
    * @return
    */
   public static CartItemModel mapCartItemEntityToCartItemModel(CartItem item)
   {
      CartItemModel model = new CartItemModel();
      if (item != null)
      {
         model.setId(item.getId());
         model.setProductId(item.getProductId());
         model.setQuantity(item.getQuantity());
         model.setUserId(item.getUser().getId());
         model.setProductName(item.getProductName());
         model.setPrice(item.getPrice());
         model.setCurrency(item.getCurrency());
      }
      return model;
   }

   /**
    * TODO
    * 
    * @param newOrder
    * @return
    */
   public static OrdersModel mapOrderEntityToOrderModel(Orders newOrder)
   {
      OrdersModel model = new OrdersModel();
      if (newOrder != null)
      {
         model.setOrderId(newOrder.getOrderId());
         model.setUserId(newOrder.getUser().getId());
         model.setProductId(newOrder.getProductId());
         model.setProductName(newOrder.getProductName());
         model.setProductPrice(newOrder.getProductPrice());
         model.setCurrency(newOrder.getCurrency());
         model.setQuantity(newOrder.getQuantity());
         model.setStatus(newOrder.getStatus());
         model.setShippingAddress(newOrder.getShippingAddress());
         model.setOrderDate(newOrder.getOrderDate());
      }
      return model;
   }

   /**
    * TODO
    * 
    * @param address
    * @return
    */
   public static AddressModel mapAddressEntityToAddressModel(Address address)
   {
      AddressModel model = new AddressModel();
      if (address != null)
      {
         model.setAddressId(address.getAddressId());
         model.setAddress(address.getAddress());
         model.setCity(address.getCity());
         model.setState(address.getState());
         model.setZipCode(address.getZipCode());
         model.setEmail(address.getEmail());
         model.setPhone(address.getPhone());
         model.setCountry(address.getCountry());
      }
      return model;
   }

   /**
    * TODO
    * 
    * @param orders
    * @return
    */
   public static List<OrdersModel> mapOrderEntitiesToOrderModels(List<Orders> orders)
   {
      List<OrdersModel> orderModels = new ArrayList<OrdersModel>();
      if (!CollectionUtils.isEmpty(orders))
      {
         orders.forEach(order -> {
            orderModels.add(mapOrderEntityToOrderModel(order));
         });
      }
      return orderModels;
   }
}
