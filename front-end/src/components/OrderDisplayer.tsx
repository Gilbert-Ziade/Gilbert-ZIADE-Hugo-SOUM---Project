import { Card, Typography } from "@mui/material";

export interface Product {
    id: number;
    productName: string;
    unitPrice: number;
}
export interface Order {
    id: number;
    date: string;
    quantity: number;
    product: Product;
}
export interface OrderDisplayerProps {
    orders: Order[]
}

const OrderDisplayer = (props: OrderDisplayerProps) => {
    const { orders } = props;
  return (
    <div>
        <Typography variant="h1">Order</Typography>

    <div style={{
        display: 'flex',
        flexDirection: 'row',
        alignItems: 'center',
        padding: '1rem',
        gap: '1rem',
    }}>
        {orders.map((order, index) => (
            <Card key={index}>
                <Typography variant="h2">Order n°{order.id}</Typography>
                <Typography variant="body1">{order.date}</Typography>
                <Typography variant="body1">Quantity: {order.quantity}</Typography>
                <Typography variant="body1">Product: {order.product.productName}</Typography>
                <Typography variant="body1">Unit Price: {order.product.unitPrice}</Typography>
            </Card>
        ))}
    </div>
    </div>
  );
};


export default OrderDisplayer;