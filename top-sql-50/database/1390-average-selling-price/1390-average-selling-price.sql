# Write your MySQL query statement below
Select  p.product_id
        , Round(COALESCE(
        SUM(CASE WHEN u.purchase_date BETWEEN p.start_date AND p.end_date 
                 THEN p.price * u.units 
                 ELSE 0 END) 
        / NULLIF(SUM(CASE WHEN u.purchase_date BETWEEN p.start_date AND p.end_date 
                          THEN u.units 
                          ELSE 0 END), 0)
        ,0
        ),2)AS average_price
From Prices as p Left join UnitsSold as u on p.product_id=u.product_id Group by p.product_id;