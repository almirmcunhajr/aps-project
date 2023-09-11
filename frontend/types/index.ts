import { MouseEventHandler } from "react";

export interface ButtonProps {
  containerStyles?: string;
  handleClick?: MouseEventHandler<HTMLButtonElement>;
  icon?: React.ReactNode,
  title?: string;
  type?: "button" | "submit";
}

export interface InputProps {
  autocomplete?: "on" | "off";
  containerStyles?: string;
  onChange: (value: string) => void;
  placeholder?: string;
  type?: string;
  value: string;
}

export interface CardProps {
  extId: string;
  language: string;
  overview: string;
  title: string;
  type: string;
}

export interface PaginationProps {
  page: string;
  query: string;
  showNextPage: boolean;
}

interface BannerContentType {
  extId: string;
  link: string;
}

export interface BannerProps {
  content: BannerContentType[];
}

export interface SearchContentType {
  description: string;
  extId: string;
  title: string;
  type: string;
}

export interface ContentType {
  genres?: string[];
  overview: string;
  language: string;
  title: string;
  type: string;
  extId: number;
}

export interface UserType {
  email?: string;
  name?: string;
}

export interface SearchBarProps {
  text?: string;
}

export interface ApiProps {
  link: string;
}

export interface GetContentProps {
  query: string;
  page: string;
}

export interface ModalProps {
  content: ContentType;
  onClose: () => void;
  showModal: boolean;
}

export interface ContentProps {
  content: ContentType;
}